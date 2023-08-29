package net.wampel.aq.items;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.wampel.aq.AQ;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {

    VTURTLE(25,
            new int[] {2,5,6,2},
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,
            () -> Ingredient.ofItems(Items.SCUTE),
            "vturtle",
            0F,
            0.0F
            ),
    TURTLE(42,
             new int[] {3,6,8,3},
            15,
            SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,
            () -> Ingredient.ofItems(ModItems.TURTLE_INGOT),
            "aqturtle",
            3.0F,
            0.2F
            );

    private final int durabilityMultiplier ;
    private final int[] protection;
    private final int enchantibility;
    private final SoundEvent equipSound;
    private final Supplier<Ingredient> repairIngredient;
    private final String name;
    private final float toughness;

    private final float knockbackRessistance;

    private static final  int[] BASE_DURABILITY = {11, 16, 15, 13};

    ModArmorMaterials(int durabilityMultiplier, int[] protection, int enchantibility, SoundEvent equipSound, Supplier<Ingredient> repairIngredient, String name, float toughness, float knockbackRessistance) {
        this.durabilityMultiplier = durabilityMultiplier;
        this.protection = protection;
        this.enchantibility = enchantibility;
        this.equipSound = equipSound;
        this.repairIngredient = repairIngredient;
        this.name = name;
        this.toughness = toughness;
        this.knockbackRessistance = knockbackRessistance;
    }
    @Override
    public int getDurability(ArmorItem.Type type) {
        return this.BASE_DURABILITY[type.ordinal()];
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protection[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantibility;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return AQ.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackRessistance;
    }
}
