package net.lostforgotten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.lostforgotten.util.ModTags;
import net.lostforgotten.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
                //.add(ModItems.)
                //.add(Items.APPLE);

        //valueLookupBuilder(ItemTags.LOGS_THAT_BURN)
                //.add(ModBlocks.STRIPPED_DRIFTWOOD_WOOD.asItem());

        //valueLookupBuilder(ItemTags.PLANKS)
                //.add(ModBlocks.DRIFTWOOD_PLANKS.asItem());
    }
}
