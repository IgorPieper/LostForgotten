package net.lostforgotten;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.lostforgotten.block.ModBlocks;
import net.lostforgotten.item.ModItemGroups;
import net.lostforgotten.item.ModItems;
import net.lostforgotten.sound.ModSounds;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostForgotten implements ModInitializer {
	public static final String MOD_ID = "lostforgotten";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModSounds.registerSounds();

		ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, list) -> {
			if (itemStack.isOf(ModBlocks.MOSSY_COBBLESTONE_MK1.asItem())){
				list.add(Text.translatable("tooltip.tutorialmod.universal_retro.tooltip"));
				return;
			}
		});
	}
}