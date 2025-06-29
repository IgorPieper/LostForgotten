package net.lostforgotten;

import net.fabricmc.api.ModInitializer;

import net.lostforgotten.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostForgotten implements ModInitializer {
	public static final String MOD_ID = "lostforgotten";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}