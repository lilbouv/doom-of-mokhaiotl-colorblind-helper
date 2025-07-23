package com.doomcb;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("Animation Options")
public interface DoomColorBlindConfig extends Config
{
	enum ProjectileTheme
	{
		INFERNO,
		TOA
	}

	@ConfigItem(
			keyName = "projectileTheme",
			name = "Projectile Theme",
			description = "Choose visual style for replacing Doom projectiles"
	)
	default ProjectileTheme projectileTheme()
	{
		return ProjectileTheme.INFERNO;
	}
}
