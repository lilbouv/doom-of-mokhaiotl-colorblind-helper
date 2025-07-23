package com.doomcb;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class DoomColorBlindPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(DoomColorBlindPlugin.class);
		RuneLite.main(args);
	}
}