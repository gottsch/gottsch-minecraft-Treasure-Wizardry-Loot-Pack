package com.someguyssoftware.treasure_wizardry_lootpack.eventhandler;

import com.someguyssoftware.gottschcore.mod.IMod;
import com.someguyssoftware.gottschcore.world.WorldInfo;
import com.someguyssoftware.treasure2.loot.TreasureLootTableRegistry;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldEventHandler {
    	// reference to the mod.
	private IMod mod;
	
	/**
	 * 
	 */
	public WorldEventHandler(IMod mod) {
		setMod(mod);
	}

	@SubscribeEvent(priority = EventPriority.LOW)
	public void onWorldLoad(WorldEvent.Load event) {
        
        if (!getMod().getConfig().isModEnabled()) {
			return;
        }
        
		/*
		 * On load of dimension 0 (overworld), initialize the loot table's context and other static loot tables
		 */
		if (WorldInfo.isServerSide(event.getWorld()) && event.getWorld().provider.getDimension() == 0) {
			// register mod's loot tables with the LootTableMaster
			TreasureLootTableRegistry.register(mod.getId());
		}	
	}
	
	/**
	 * @return the mod
	 */
	public IMod getMod() {
		return mod;
	}

	/**
	 * @param mod the mod to set
	 */
	public void setMod(IMod mod) {
		this.mod = mod;
	}

}