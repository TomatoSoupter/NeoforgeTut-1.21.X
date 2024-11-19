package net.tomatosoupter.tutorialmod.item.weaponTiers;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import io.redspace.ironsspellbooks.registries.ItemRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public class TutorialModWeaponTiers implements Tier, IronsWeaponTier {

    public static TutorialModWeaponTiers VISCERA_SPEAR = new TutorialModWeaponTiers(2   000, 6, -2.8f, 10, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, () -> Ingredient.of(Items.NETHERITE_SCRAP),
    new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));



    @Override
    public int getUses() {
        return 0;
    }

    @Override
    public float getSpeed() {
        return 0;
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return new AttributeContainer[0];
    }

    @Override
    public float getAttackDamageBonus() {
        return 0;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return null;
    }

    @Override
    public int getEnchantmentValue() {
        return 0;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
