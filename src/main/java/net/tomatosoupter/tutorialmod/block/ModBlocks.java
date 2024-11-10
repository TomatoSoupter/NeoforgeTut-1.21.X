package net.tomatosoupter.tutorialmod.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomatosoupter.tutorialmod.TutorialMod;
import net.tomatosoupter.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(TutorialMod.MOD_ID);

    public static final DeferredBlock<Block> DAUB_BLOCK = registerBlock("daub",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<StairBlock> DAUB_STAIRS = registerBlock("daub_stairs",
            () -> new StairBlock(ModBlocks.DAUB_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of()
                            .strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD).mapColor(DyeColor.WHITE)));

    public static final DeferredBlock<SlabBlock> DAUB_SLAB = registerBlock("daub_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of().strength(0.5f).requiresCorrectToolForDrops().sound(SoundType.PACKED_MUD).mapColor(DyeColor.WHITE)));
    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

}