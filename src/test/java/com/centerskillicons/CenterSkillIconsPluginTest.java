package com.centerskillicons;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class CenterSkillIconsPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(CenterSkillIconsPlugin.class);
		RuneLite.main(args);
	}
}