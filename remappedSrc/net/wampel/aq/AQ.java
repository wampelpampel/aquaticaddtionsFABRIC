package net.wampel.aq;

import net.fabricmc.api.ModInitializer;

import net.wampel.aq.blocks.ModBlocks;
import net.wampel.aq.items.ModItemGroups;
import net.wampel.aq.items.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AQ implements ModInitializer {
	public static final String MOD_ID = "aq";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.regusterItemGroups();
		ModBlocks.registerModBlocks();
		ModItems.registerModItems();
	}
}