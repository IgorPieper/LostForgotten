package net.lostforgotten.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.lostforgotten.LostForgotten;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block WAX_BLOCK = registerBlock("wax_block",
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.HONEY));

    public static final Block RUBY_BLOCK = registerBlock("ruby_block",
            AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.AMETHYST_BLOCK));

    public static final Block RUBY_ORE = registerBlock("ruby_ore",
            AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.STONE));

    public static final Block DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE));

    public static final Block MOSSY_COBBLESTONE_MK1 = registerBlock("mossy_cobblestone_mk1",
            AbstractBlock.Settings.create().strength(2f).requiresTool().sounds(BlockSoundGroup.MOSS_BLOCK));

    private static Block registerBlock(String name, AbstractBlock.Settings blockSettings) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LostForgotten.MOD_ID, name));
        Block block = new Block(blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LostForgotten.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        LostForgotten.LOGGER.info("Registering Mod Blocks for " + LostForgotten.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.WAX_BLOCK);
        });
    }
}
