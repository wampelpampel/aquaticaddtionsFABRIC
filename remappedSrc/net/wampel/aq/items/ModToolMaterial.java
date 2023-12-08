package net.wampel.aq.items;

import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    TURTLE(2400, 8.5F, 4.5F, 4, 18, () -> Ingredient.ofItems(ModItems.TURTLE_INGOT));
    private final int durablity;
    private final float miningSpeed;
    private final float attackDamage;
    private final int miningLevel;
    private final int enchantibilty;
    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterial(int durablity, float miningSpeed, float attackDamage, int miningLevel, int enchantibilty, Supplier<Ingredient> repairIngredient) {
        this.durablity = durablity;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantibilty = enchantibilty;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return this.durablity;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantibilty;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
