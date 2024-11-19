package net.tomatosoupter.tutorialmod.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.tomatosoupter.tutorialmod.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DAUB_BLOCK.get(), 5)
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A', Items.MUD)
                .define('B', Items.WHEAT)
                .define('C', Items.CLAY)
                .unlockedBy("has_mud", has(Items.MUD)).save(recipeOutput);

        stairBuilder(ModBlocks.DAUB_STAIRS.get(),Ingredient.of(ModBlocks.DAUB_BLOCK)).group("daub")
                .unlockedBy("has_daub", has(ModBlocks.DAUB_BLOCK)).save(recipeOutput);
        slab(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAUB_SLAB.get(), ModBlocks.DAUB_BLOCK.get());
        wall(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.DAUB_WALL.get(), ModBlocks.DAUB_BLOCK.get());
    }
}
