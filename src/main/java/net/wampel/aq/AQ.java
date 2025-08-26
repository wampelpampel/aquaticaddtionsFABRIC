package net.wampel.aq;

import net.fabricmc.api.ModInitializer;

import net.wampel.aq.blocks.AQBlocks;
import net.wampel.aq.items.AQItemGroups;
import net.wampel.aq.items.AQItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AQ implements ModInitializer {
	public static final String MOD_ID = "aq";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		AQItemGroups.registerItemGroups();
		AQBlocks.initialize();
		AQItems.initialize();
	}
}