package com.centerskillicons;

import java.util.HashMap;

import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.events.ScriptPostFired;
import net.runelite.api.gameval.InterfaceID;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.eventbus.Subscribe;
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

	@Inject private Client client;
	@Inject private ClientThread clientThread;

	/**
	 * Initialized up the plugin when it is enabled.
	 * Stores the original positions of the skill icons and sets them to their centered positions.
	 */
	@Override
	protected void startUp() throws Exception
	{
		storeCurrentPositions();
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
	 * Update icon positions when skills panel-related scripts are executed.
	 * @param event The script post-fired event.
	 */
	@Subscribe
	public void onScriptPostFired(ScriptPostFired event) {
		storeCurrentPositions();
		if (
			event.getScriptId() == SCRIPT_ID_STATS_INIT
			|| event.getScriptId() == SCRIPT_ID_STATS_REFRESH
		) {
			updatePositions();
		}
	}

	/**
	 * Captures and stores the original positions of all skill icons in the skills panel.
	 * The overall intention is to only store positions once on the first call or after being reset, and to prohibit
	 * the execution of other operations until these positions have been stored.
	 * Validates that positions for all skills were found before committing the values to storage.
	 */
	private void storeCurrentPositions() {
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
	private void updatePositions() {
		if (originalPositions == null) return;
		setPositions(SkillData.mapping());
	}

	/**
	 * Sets the icons in the skills panel to their original positions.
	 */
	private void resetPositions() {
		if (originalPositions == null) return;
		setPositions(originalPositions);
		originalPositions = null;
	}

	/**
	 * Extracts the child ID from the ID of its parent widget.
	 * @param id The parent widget's ID.
	 * @return The child widget's ID.
	 */
	private int getChildId(int id) {
		return id & WIDGET_CHILD_ID_MASK;
	}

	/**
	 * Changes a widget's original X- and Y-coordinates and revalidates.
	 * @param widget The widget to move.
	 * @param x The new x-coordinate.
	 * @param y The new y-coordinate.
	 */
	private void moveWidget(Widget widget, int x, int y) {
		widget.setOriginalX(x);
		widget.setOriginalY(y);
		widget.revalidate();
	}

	/**
	 * Sets the positions of the icons in the skills panels to the coordinates specified in the mapping.
	 * @param mapping A hashmap mapping skills to their target coordinates.
	 */
	private void setPositions(HashMap<Skill, Coordinate> mapping) {
		Widget skillsPanel = client.getWidget(InterfaceID.Stats.UNIVERSE);
		if (skillsPanel == null) return;

		for (Widget skillWidget : skillsPanel.getStaticChildren()) {
			int idx = getChildId(skillWidget.getId()) - 1;
			SkillData skillData = SkillData.get(idx);
			if (skillData == null) continue;
			Widget icon = skillWidget.getChild(SKILL_ICON_INDEX);
			if (icon == null) continue;
			Coordinate coordinates = mapping.get(skillData.skill);
			moveWidget(icon, coordinates.getX(), coordinates.getY());
		}
	}
}
