package net.tomatosoupter.tutorialmod.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomatosoupter.tutorialmod.TutorialMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    //testitem for testing purposes
    public static final DeferredHolder<Item, Item> TESTITEM = ITEMS.register("testitem", () -> {
       return new Item(new Item.Properties());
    });

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
