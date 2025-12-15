package com.centerskillicons;

import java.util.HashMap;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.Skill;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.events.ConfigChanged;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Center Skill Icons",
	description = "Better position the icons in the skills panel",
	tags = {"skills", "icons", "center", "fix"}
)
public class CenterSkillIconsPlugin extends Plugin
{
	private static final int SCRIPT_ID_STATS_INIT = 394;
	private static final int SCRIPT_ID_STATS_REFRESH = 393;
	private static final int WIDGET_CHILD_ID_MASK = 0xFFFF;
	private static final int SKILL_ICON_INDEX = 2; // NOTE: Possibly not always correctly
	private HashMap<Skill, Coordinate> originalPositions;
	private HashMap<Skill, Coordinate> preferredPositions; // Configuration variable

	@Inject private Client client;
	@Inject private CenterSkillIconsConfig config;
	@Inject private ClientThread clientThread;

	/**
	 * Initialized the plugin when it is enabled.
	 * Stores the original positions of the skill icons and sets them to their centered positions.
	 */
	@Override
	protected void startUp() throws Exception
	{
		storeCurrentPositions();
		updateConfig();
		clientThread.invoke(this::updatePositions);
	}

	/**
	 * Cleans up the plugin when it is disabled.
	 * Resets all skill icons to their original positions.
	 */
	@Override
	protected void shutDown() throws Exception
	{
		clientThread.invoke(this::resetPositions);
	}

	/**
	 * Updates the positions for the skill icons whenever the plugin's configuration has been changed.
	 * @param event The event received upon change of configuration.
	 */
	@Subscribe
	public void onConfigChanged(ConfigChanged event)
	{
		if (!event.getGroup().equals(CenterSkillIconsConfig.GROUP_NAME)) return;
		updateConfig();
		clientThread.invoke(this::updatePositions);
	}

	/**
	 * Update icon positions when skills panel-related scripts are executed.
	 * @param event The event received after a script is fired.
	 */
	@Subscribe
	public void onScriptPostFired(ScriptPostFired event)
	{
		storeCurrentPositions();
		if (
			event.getScriptId() == SCRIPT_ID_STATS_INIT
			|| event.getScriptId() == SCRIPT_ID_STATS_REFRESH
		) {
			updatePositions();
		}
	}

	/**
	 * Updates the stored skill positions with values determined by the plugin configuration.
	 */
	public void updateConfig() {
		if (preferredPositions == null) {
			preferredPositions = new HashMap<>();
		}
		preferredPositions.put(SkillData.ATTACK.skill, new Coordinate(config.positionAttackX(), config.positionAttackY()));
		preferredPositions.put(SkillData.STRENGTH.skill, new Coordinate(config.positionStrengthX(), config.positionStrengthY()));
		preferredPositions.put(SkillData.DEFENCE.skill, new Coordinate(config.positionDefenceX(), config.positionDefenceY()));
		preferredPositions.put(SkillData.RANGED.skill, new Coordinate(config.positionRangedX(), config.positionRangedY()));
		preferredPositions.put(SkillData.PRAYER.skill, new Coordinate(config.positionPrayerX(), config.positionPrayerY()));
		preferredPositions.put(SkillData.MAGIC.skill, new Coordinate(config.positionMagicX(), config.positionMagicY()));
		preferredPositions.put(SkillData.RUNECRAFT.skill, new Coordinate(config.positionRunecraftX(), config.positionRunecraftY()));
		preferredPositions.put(SkillData.CONSTRUCTION.skill, new Coordinate(config.positionConstructionX(), config.positionConstructionY()));
		preferredPositions.put(SkillData.HITPOINTS.skill, new Coordinate(config.positionHitpointsX(), config.positionHitpointsY()));
		preferredPositions.put(SkillData.AGILITY.skill, new Coordinate(config.positionAgilityX(), config.positionAgilityY()));
		preferredPositions.put(SkillData.HERBLORE.skill, new Coordinate(config.positionHerbloreX(), config.positionHerbloreY()));
		preferredPositions.put(SkillData.THIEVING.skill, new Coordinate(config.positionThievingX(), config.positionThievingY()));
		preferredPositions.put(SkillData.CRAFTING.skill, new Coordinate(config.positionCraftingX(), config.positionCraftingY()));
		preferredPositions.put(SkillData.FLETCHING.skill, new Coordinate(config.positionFletchingX(), config.positionFletchingY()));
		preferredPositions.put(SkillData.SLAYER.skill, new Coordinate(config.positionSlayerX(), config.positionSlayerY()));
		preferredPositions.put(SkillData.HUNTER.skill, new Coordinate(config.positionHunterX(), config.positionHunterY()));
		preferredPositions.put(SkillData.MINING.skill, new Coordinate(config.positionMiningX(), config.positionMiningY()));
		preferredPositions.put(SkillData.SMITHING.skill, new Coordinate(config.positionSmithingX(), config.positionSmithingY()));
		preferredPositions.put(SkillData.FISHING.skill, new Coordinate(config.positionFishingX(), config.positionFishingY()));
		preferredPositions.put(SkillData.COOKING.skill, new Coordinate(config.positionCookingX(), config.positionCookingY()));
		preferredPositions.put(SkillData.FIREMAKING.skill, new Coordinate(config.positionFiremakingX(), config.positionFiremakingY()));
		preferredPositions.put(SkillData.WOODCUTTING.skill, new Coordinate(config.positionWoodcuttingX(), config.positionWoodcuttingY()));
		preferredPositions.put(SkillData.FARMING.skill, new Coordinate(config.positionFarmingX(), config.positionFarmingY()));
		preferredPositions.put(SkillData.SAILING.skill, new Coordinate(config.positionSailingX(), config.positionSailingY()));
	}

	/**
	 * Captures and stores the original positions of all skill icons in the skills panel.
	 * The overall intention is to only store positions once on the first call or after being reset, and to prohibit
	 * the execution of other operations until these positions have been stored.
	 * Validates that positions for all skills were found before committing the values to storage.
	 */
	private void storeCurrentPositions()
	{
		if (originalPositions != null) return;

		Widget skillsPanel = client.getWidget(InterfaceID.Stats.UNIVERSE);
		if (skillsPanel == null) return;

		HashMap<Skill, Coordinate> temporary = new HashMap<>();
		for (Widget skillWidget : skillsPanel.getStaticChildren()) {
			int idx = getChildId(skillWidget.getId()) - 1;
			SkillData skillData = SkillData.get(idx);
			if (skillData == null) continue;
			Widget icon = skillWidget.getChild(SKILL_ICON_INDEX);
			if (icon == null) continue;
			temporary.put(skillData.skill, new Coordinate(icon.getOriginalX(), icon.getOriginalY()));
		}

		if (!temporary.isEmpty() && (temporary.values().toArray().length == SkillData.values().length)) {
			originalPositions = temporary;
		}
	}

	/**
	 * Sets the icons in the skills panel to their default corrected positions.
	 * The default positions are specified in the SkillData enum.
	 */
	private void updatePositions()
	{
		if (originalPositions == null || preferredPositions == null) return;
		setPositions(preferredPositions);
	}

	/**
	 * Sets the icons in the skills panel to their original positions.
	 */
	private void resetPositions()
	{
		if (originalPositions == null) return;
		setPositions(originalPositions);
		originalPositions = null;
	}

	/**
	 * Extracts the child ID from the ID of its parent widget.
	 * @param id The parent widget's ID.
	 * @return The child widget's ID.
	 */
	private int getChildId(int id)
	{
		return id & WIDGET_CHILD_ID_MASK;
	}

	/**
	 * Changes a widget's original X- and Y-coordinates and revalidates.
	 * @param widget The widget to move.
	 * @param x The new x-coordinate.
	 * @param y The new y-coordinate.
	 */
	private void moveWidget(Widget widget, int x, int y)
	{
		widget.setOriginalX(x);
		widget.setOriginalY(y);
		widget.revalidate();
	}

	/**
	 * Sets the positions of the icons in the skills panels to the coordinates specified in the mapping.
	 * @param mapping A hashmap mapping skills to their target coordinates.
	 */
	private void setPositions(HashMap<Skill, Coordinate> mapping)
	{
		Widget skillsPanel = client.getWidget(InterfaceID.Stats.UNIVERSE);
		if (skillsPanel == null) return;

		for (Widget skillWidget : skillsPanel.getStaticChildren()) {
			int idx = getChildId(skillWidget.getId()) - 1;
			SkillData skillData = SkillData.get(idx);
			if (skillData == null) continue;
			Widget icon = skillWidget.getChild(SKILL_ICON_INDEX);
			if (icon == null) continue;
			Coordinate coordinates = mapping.get(skillData.skill);
			if (coordinates == null) continue;
			moveWidget(icon, coordinates.getX(), coordinates.getY());
		}
	}

	@Provides
	CenterSkillIconsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(CenterSkillIconsConfig.class);
	}
}
