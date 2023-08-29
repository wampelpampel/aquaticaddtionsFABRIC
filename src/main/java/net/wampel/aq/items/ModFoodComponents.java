package net.wampel.aq.items;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent TURTLE_APPLE = new FoodComponent.Builder()
            .hunger(4).saturationModifier(0.25F)
            .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 2*60*20, 4), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 1*60*20), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1*60*20), 1F)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1*60*20, 3), 1F)

            .build();

    public static final FoodComponent GOLDEN_FISH = new FoodComponent.Builder()
            .hunger(6).saturationModifier(14.4F)
            .build();

}