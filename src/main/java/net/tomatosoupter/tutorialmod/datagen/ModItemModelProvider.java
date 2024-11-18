package net.tomatosoupter.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.tomatosoupter.tutorialmod.TutorialMod;
import net.tomatosoupter.tutorialmod.block.ModBlocks;
import net.tomatosoupter.tutorialmod.registry.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, TutorialMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ModItems.TESTITEM.get());

        wallItem(ModBlocks.DAUB_WALL, ModBlocks.DAUB_BLOCK);



    }

    public void wallItem(DeferredBlock<?> block, DeferredBlock<Block> baseBlock) {
        this.withExistingParent(block.getId().getPath(), mcLoc("block/wall_inventory"))
                .texture("wall",  ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID,
                        "block/" + baseBlock.getId().getPath()));
    }
}
