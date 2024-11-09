package net.tomatosoupter.tutorialmod.mod_tab;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.CreativeModeTabRegistry;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomatosoupter.tutorialmod.TutorialMod;
import net.tomatosoupter.tutorialmod.item.ModItems;

public class ModCreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MOD_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TutorialMod.MOD_ID);
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> THINGS = CREATIVE_MOD_TABS.register("test", () ->
            CreativeModeTab.builder()
                    .withTabsBefore(CreativeModeTabs.INGREDIENTS)
                    .title(Component.translatable("tab.tutorial_mod.test"))
                    .icon(() -> new ItemStack(ModItems.TESTITEM))
                    .displayItems((enabledFeatures, entries) -> {
                        entries.accept(ModItems.TESTITEM.get());
                    })
                    .build()
    );
}
