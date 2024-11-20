package net.tomatosoupter.tutorialmod.registry;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.tomatosoupter.tutorialmod.TutorialMod;
import net.tomatosoupter.tutorialmod.item.weaponTiers.TutorialModWeaponTiers;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TutorialMod.MOD_ID);

    //testitem for testing purposes
    public static final DeferredHolder<Item, Item> TESTITEM = ITEMS.register("testitem", () -> {
       return new Item(new Item.Properties());
    });

    //Daggers
    public static final DeferredItem<SwordItem> DAGGER = ITEMS.register("dagger",
            () -> new SwordItem(Tiers.IRON, new Item.Properties()
                    .attributes(SwordItem.createAttributes(Tiers.IRON, 1, -2f))));

    //Viscera Spear
    public static final DeferredItem<SwordItem> VISCERA_SPEAR = ITEMS.register("viscera_spear",
            () -> new SwordItem(TutorialModWeaponTiers.VISCERA_SPEAR, new Item.Properties()
                    .attributes(SwordItem.createAttributes(TutorialModWeaponTiers.VISCERA_SPEAR, 0, -2.8f))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
