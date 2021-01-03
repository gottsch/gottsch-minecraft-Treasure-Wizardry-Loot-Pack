package com.someguyssoftware.treasure_wizardry_lootpack;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.someguyssoftware.gottschcore.annotation.Credits;
import com.someguyssoftware.gottschcore.config.IConfig;
import com.someguyssoftware.gottschcore.mod.AbstractMod;
import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.version.BuildVersion;
import com.someguyssoftware.treasure_wizardry_lootpack.config.ModConfig;
import com.someguyssoftware.treasure_wizardry_lootpack.eventhandler.WorldEventHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * 
 * @author Mark Gottschling on Dec 25, 2020
 *
 */
@Mod(modid = TreasureWizardryLP.MODID, 
name = TreasureWizardryLP.NAME, 
version = TreasureWizardryLP.VERSION, 
dependencies = "required-after:gottschcore@[1.14.0,);required-after:treasure2@[1.14.0,);required-after:ebwizardry@[12.0.3,)", 
acceptedMinecraftVersions = "[1.12.2]", 
updateJSON = TreasureWizardryLP.UPDATE_JSON_URL)
@Credits(values = { "Treasure2: Wizardry Loot Pack was first developed by Mark Gottschling on Dec 11, 2020."})
public class TreasureWizardryLP extends AbstractMod {
	// constants
	public static final String MODID = "treasure2_wizardry_lp";
	protected static final String NAME = "Treasure2WizardryLP";
	protected static final String VERSION = "1.0.0";

	public static final String UPDATE_JSON_URL = "https://raw.githubusercontent.com/gottsch/gottsch-minecraft-Treasure-Wizardry-Loot-Pack/1.12.2-master/update.json";

	private static final BuildVersion MINECRAFT_VERSION = new BuildVersion(1, 12, 2);

	// latest version
	private static BuildVersion latestVersion;

	// logger
	public static Logger LOGGER = LogManager.getLogger(TreasureWizardryLP.NAME);

	@Instance(value = TreasureWizardryLP.MODID)
	public static TreasureWizardryLP instance;

	/**
	 * 
	 */
	public TreasureWizardryLP() {

	}

	/**
	 * 
	 * @param event
	 */
	@Override
	@EventHandler
	public void preInt(FMLPreInitializationEvent event) {
		super.preInt(event);

		// register additional events
		MinecraftForge.EVENT_BUS.register(new WorldEventHandler(getInstance()));
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		if (!getConfig().isModEnabled()) {
			return;
		}

		// perform any post init
		super.postInit(event);
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getConfig()
	 */
	@Override
	public IConfig getConfig() {
		return ModConfig.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getMinecraftVersion()
	 */
	@Override
	public BuildVersion getMinecraftVersion() {
		return TreasureWizardryLP.MINECRAFT_VERSION;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getVerisionURL()
	 */
	@Override
	public String getVerisionURL() {
		return "";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getName()
	 */
	@Override
	public String getName() {
		return TreasureWizardryLP.NAME;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.IMod#getId()
	 */
	@Override
	public String getId() {
		return TreasureWizardryLP.MODID;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getInstance()
	 */
	@Override
	public IMod getInstance() {
		return TreasureWizardryLP.instance;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.someguyssoftware.gottschcore.mod.AbstractMod#getVersion()
	 */
	@Override
	public String getVersion() {
		return TreasureWizardryLP.VERSION;
	}

	@Override
	public BuildVersion getModLatestVersion() {
		return latestVersion;
	}

	@Override
	public void setModLatestVersion(BuildVersion version) {
		TreasureWizardryLP.latestVersion = version;
	}

	@Override
	public String getUpdateURL() {
		return TreasureWizardryLP.UPDATE_JSON_URL;
	}
}