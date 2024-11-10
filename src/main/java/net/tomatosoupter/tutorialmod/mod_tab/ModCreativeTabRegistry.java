package net.tomatosoupter.tutorialmod.mod_tab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomatosoupter.tutorialmod.TutorialMod;
import net.tomatosoupter.tutorialmod.block.ModBlocks;
import net.tomatosoupter.tutorialmod.item.ModItems;

import java.util.function.Supplier;

public class ModCreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);

    public static final Supplier<CreativeModeTab> TEST_ITEM_TAB = CREATIVE_MODE_TAB.register("test_item_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TESTITEM.get()))
                    .title(Component.translatable("tab.tutorial_mod.items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TESTITEM.get());
                    }).build());

    public static final Supplier<CreativeModeTab> TEST_BLOCK_TAB = CREATIVE_MODE_TAB.register("test_block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.DAUB_BLOCK.get()))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(TutorialMod.MOD_ID, "test_item_tab"))
                    .title(Component.translatable("tab.tutorial_mod.blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.DAUB_BLOCK.get());
                        output.accept(ModBlocks.DAUB_STAIRS.get());
                        output.accept(ModBlocks.DAUB_SLAB.get());
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
