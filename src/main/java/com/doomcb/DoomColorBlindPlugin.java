package com.doomcb;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Projectile;
import net.runelite.api.events.ProjectileMoved;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
		name = "Doom Colorblind Helper",
		description = "Replaces Doom projectiles with Inferno blob colors for better visibility",
		tags = {"doom", "colorblind", "projectile"}
)
public class DoomColorBlindPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private DoomColorBlindConfig config;

	@Provides
	DoomColorBlindConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(DoomColorBlindConfig.class);
	}

	@Subscribe
	public void onProjectileMoved(ProjectileMoved event)
	{
		Projectile proj = event.getProjectile();
		int id = proj.getId();

		int replacementId = -1;

		final int RANGE_ROCK_PROJECTILE = 3384;
		final int MAGE_ROCK_PROJECTILE = 3385;
		final int ZEBAK_RANGE_PROJECTILE = 2178;
		final int ZEBAK_MAGE_PROJECTILE = 2176;

		switch (id)
		{

			//
			case 3380: // Doom range
				switch(config.projectileTheme())
				{
					case TOA:
						replacementId = 2241;
						break;
					case INFERNO:
						replacementId = 1378;
						break;
					case OLM:
						replacementId = 1343;
						break;
					case LEVIATHAN:
						replacementId = 2487;
						break;
				}
				break;

			case 3379: // Doom magic
				switch(config.projectileTheme())
				{
					case TOA:
						replacementId = 2224;
						break;
					case INFERNO:
						replacementId = 1380;
						break;
					case OLM:
						replacementId = 1341;
						break;
					case LEVIATHAN:
						replacementId = 2489;
						break;
				}
				break;
			case 3378: // Doom melee
				if (!config.replaceMelee())
					break;
				switch(config.projectileTheme())
				{
					case TOA:
						replacementId = 2204;
						break;
					case OLM:
						replacementId = 1345;
						break;
					case LEVIATHAN:
						replacementId = 2488;
						break;
					// No Inferno Melee
				}
				break;
			case RANGE_ROCK_PROJECTILE:
				if (config.toathemedRock()) {
					replacementId = ZEBAK_RANGE_PROJECTILE;
				}
				break;
			case MAGE_ROCK_PROJECTILE:
				if (config.toathemedRock()) {
					replacementId = ZEBAK_MAGE_PROJECTILE;
				}
				break;
		}

		if (replacementId == -1)
			return;

		log.debug("Replacing Doom projectile ID {} with {}", id, replacementId);

		Projectile replacement = client.createProjectile(
				replacementId,
				proj.getSourcePoint(),
				proj.getStartHeight(), proj.getSourceActor(),
				proj.getTargetPoint(),
				proj.getEndHeight(), proj.getTargetActor(),
				proj.getStartCycle(), proj.getEndCycle(),
				proj.getSlope(), proj.getStartPos()
		);

		client.getProjectiles().addLast(replacement);
		proj.setEndCycle(0); // Hide original
	}
}
