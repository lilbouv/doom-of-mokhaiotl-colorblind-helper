package com.doomcb;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;
import net.runelite.client.config.ConfigSection;
import net.runelite.client.config.Range;
import net.runelite.client.config.Units;

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

	@ConfigSection(
			name = "Loot Sound",
			description = "",
			position = 0,
			closedByDefault = true
	)
	String SECTION_LOOT_SOUND = "lootSound";

	String CONFIG_KEY_LOOT_SOUND_ENABLED = "lootSoundEnabled";

	@ConfigItem(
			name = "Enable Loot Sound",
			keyName = CONFIG_KEY_LOOT_SOUND_ENABLED,
			description = "Play a loot sound effect on unique.",
			position = 0,
			section = SECTION_LOOT_SOUND
	)
	default boolean lootSoundEnabled()
	{
		return true;
	}

	String CONFIG_KEY_LOOT_SOUND_ID = "lootSoundId";

	@ConfigItem(
			name = "Sound ID",
			keyName = CONFIG_KEY_LOOT_SOUND_ID,
			description = "The ID of the sound effect to play." +
				"<br>Default = 10224.",
			position = 1,
			section = SECTION_LOOT_SOUND
	)
	default int lootSoundId()
	{
		return 10224;
	}

	String CONFIG_KEY_LOOT_SOUND_VOLUME = "lootSoundVolume";

	@Range(max = 100)
	@Units(Units.PERCENT)
	@ConfigItem(
			name = "Sound Volume",
			keyName = CONFIG_KEY_LOOT_SOUND_VOLUME,
			description = "Loot sound volume.",
			position = 2,
			section = SECTION_LOOT_SOUND
	)
	default int lootSoundVolume()
	{
		return 50;
	}
}
