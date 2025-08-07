package com.doomcb;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("doomcolorblind")
public interface DoomColorBlindConfig extends Config
{
	enum ProjectileTheme
	{
		NONE,
		INFERNO,
		TOA,
		OLM,
		LEVIATHAN
	}

	@ConfigItem(
			keyName = "projectileTheme",
			name = "Projectile Theme",
			description = "Choose visual style for replacing Doom projectiles"
	)
	default ProjectileTheme projectileTheme()
	{
		return ProjectileTheme.TOA;
	}
	@ConfigItem(
			keyName = "replaceMelee",
			name = "Replace Melee Projectiles",
			description = "Toggle whether melee projectile animations are replaced (Inferno doesn't regardless)"
	)
	default boolean replaceMelee()
	{
		return false;
	}

	@ConfigItem(
			name = "ToA Themed Boulder",
			keyName = "themedRock",
			description = "Replace boulders with Zebak alternatives")
	default boolean toathemedRock() {
		return false;
	}

}
