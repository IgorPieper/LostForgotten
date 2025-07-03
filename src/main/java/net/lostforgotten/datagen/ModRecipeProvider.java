package net.lostforgotten.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.lostforgotten.LostForgotten;
import net.lostforgotten.block.ModBlocks;
import net.lostforgotten.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                List<ItemConvertible> RUBY = List.of(ModBlocks.RUBY_ORE, ModBlocks.DEEPSLATE_RUBY_ORE);
                List<ItemConvertible> CRYSTALLIZED_HONEY = List.of(Items.HONEY_BOTTLE, Items.HONEYCOMB);

                offerSmelting(RUBY, RecipeCategory.MISC, ModItems.RUBY, 0.25f, 200, "ruby");
                offerSmelting(CRYSTALLIZED_HONEY, RecipeCategory.MISC, ModItems.CRYSTALLIZED_HONEY, 0.25f, 200, "crystallized_honey");

                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.RUBY, RecipeCategory.DECORATIONS, ModBlocks.RUBY_BLOCK);
                offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.CRYSTALLIZED_HONEY, RecipeCategory.DECORATIONS, ModBlocks.WAX_BLOCK);

                createShapeless(RecipeCategory.MISC, ModBlocks.MOSSY_COBBLESTONE_MK1, 2)
                        .input(Blocks.MOSSY_COBBLESTONE)
                        .input(ModBlocks.MOSSY_COBBLESTONE_MK1)
                        .criterion(hasItem(Blocks.MOSSY_COBBLESTONE), conditionsFromItem(ModBlocks.MOSSY_COBBLESTONE_MK1))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.MISC, Blocks.CANDLE, 8)
                        .input(Items.STRING)
                        .input(ModItems.CRYSTALLIZED_HONEY)
                        .criterion(hasItem(Items.STRING), conditionsFromItem(ModItems.CRYSTALLIZED_HONEY))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Lost & Forgotten Recipes";
    }
}