package net.lostforgotten.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.lostforgotten.LostForgotten;
import net.lostforgotten.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup DELETED_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LostForgotten.MOD_ID, "deleted"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RUBY))
                    .displayName(Text.translatable("itemgroup.lostforgotten.deleted"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RUBY_ORE);
                        entries.add(ModBlocks.DEEPSLATE_RUBY_ORE);
                        entries.add(ModItems.RUBY);
                        entries.add(ModBlocks.RUBY_BLOCK);
                        entries.add(ModItems.CRYSTALLIZED_HONEY);
                        entries.add(ModBlocks.WAX_BLOCK);
                    }).build());

    public static final ItemGroup RETRO_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(LostForgotten.MOD_ID, "retro"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.MOSSY_COBBLESTONE_MK1))
                    .displayName(Text.translatable("itemgroup.lostforgotten.retro"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.MOSSY_COBBLESTONE_MK1);
                    }).build());


    public static void registerItemGroups() {
        LostForgotten.LOGGER.info("Registering Item Groups for " + LostForgotten.MOD_ID);
    }
}
