package net.tomatosoupter.tutorialmod.registry;

import io.redspace.ironsspellbooks.api.item.weapons.ExtendedSwordItem;
import io.redspace.ironsspellbooks.api.item.weapons.MagicSwordItem;
import io.redspace.ironsspellbooks.api.registry.SpellDataRegistryHolder;
import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.util.ItemPropertiesHelper;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
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
    public static final DeferredHolder<Item, Item> VISCERA_SPEAR = ITEMS.register("viscera_spear",
            () -> new SwordItem(TutorialModWeaponTiers.VISCERA_SPEAR, ItemPropertiesHelper.equipment().rarity(Rarity.UNCOMMON).attributes(ExtendedSwordItem.createAttributes(TutorialModWeaponTiers.VISCERA_SPEAR))));


    // This is an imbued item, leaving this here for you to reference
    // Deep Greatsword
    /*public static final DeferredHolder<Item, Item> DEEP_GREATSWORD = ITEMS.register("deep_greatsword", () ->
            new MagicSwordItem(DTEWeaponTiers.DEEP_GREATSWORD, ItemPropertiesHelper.equipment().rarity(Rarity.RARE).attributes(ExtendedSwordItem.createAttributes(DTEWeaponTiers.DEEP_GREATSWORD)),
                    SpellDataRegistryHolder.of(new SpellDataRegistryHolder(SpellRegistry.PLANAR_SIGHT_SPELL, 6))));*/

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
