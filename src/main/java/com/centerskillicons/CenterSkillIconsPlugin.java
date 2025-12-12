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
	name = "Center Skill Icons"
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

	@Override
	protected void startUp() throws Exception
	{
		storeCurrentPositions();
		clientThread.invoke(this::updatePositions);
	}

	@Override
	protected void shutDown() throws Exception
	{
		clientThread.invoke(this::resetPositions);
	}

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

	private void updatePositions() {
		if (originalPositions == null) return;
		setPositions(SkillData.mapping());
	}

	private void resetPositions() {
		if (originalPositions == null) return;
		setPositions(originalPositions);
		originalPositions = null;
	}

	private int getChildId(int id) {
		return id & WIDGET_CHILD_ID_MASK;
	}

	private void moveWidget(Widget widget, int x, int y) {
		widget.setOriginalX(x);
		widget.setOriginalY(y);
		widget.revalidate();
	}

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
