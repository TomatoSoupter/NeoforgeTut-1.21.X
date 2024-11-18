package net.tomatosoupter.tutorialmod.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.tomatosoupter.tutorialmod.TutorialMod;
import net.tomatosoupter.tutorialmod.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, TutorialMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.DAUB_BLOCK);

        stairsBlock(ModBlocks.DAUB_STAIRS.get(), blockTexture(ModBlocks.DAUB_BLOCK.get()));
        slabBlock(ModBlocks.DAUB_SLAB.get(), blockTexture(ModBlocks.DAUB_BLOCK.get()), blockTexture(ModBlocks.DAUB_BLOCK.get()));
        wallBlock(ModBlocks.DAUB_WALL.get(), blockTexture(ModBlocks.DAUB_BLOCK.get()));

        blockItem(ModBlocks.DAUB_STAIRS);
        blockItem(ModBlocks.DAUB_SLAB);
        blockItem(ModBlocks.DAUB_WALL);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock) {
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorial_mod:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("tutorial_mod:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
