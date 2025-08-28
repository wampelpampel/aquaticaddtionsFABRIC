package net.wampel.aq.items.armor;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.server.world.ServerWorld;
import net.wampel.aq.items.AQArmorMaterials;
import net.wampel.aq.items.AQItems;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Map;

public class TurtleMasterArmorItem extends Item {

    public static final int effectDurationInSeconds = 10*20;
    public static final int effectAmplifier = 0;
    public static final boolean isEffectVisible = false;
    public static final boolean isEffectAmbient = false;

    private static final Map<ArmorMaterial, List<StatusEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, List<StatusEffectInstance>>())
                    .put(AQArmorMaterials.AQ_TURTLE_MASTER_INSTANCE,
                            List.of(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, effectDurationInSeconds, effectAmplifier, isEffectAmbient, isEffectVisible))).build();

    public TurtleMasterArmorItem(Settings settings) {
        super(settings);
    }

    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if(!world.isClient()) {
            if(entity instanceof PlayerEntity player) {
                if(hasFullSuitOfArmorOn(player)) {
                    evaluateArmorEffects(player);
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot);
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, List<StatusEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            List<StatusEffectInstance> mapStatusEffects = entry.getValue();

            if(hasCorrectArmorOn(player)) {
                addStatusEffectForMaterial(player, mapStatusEffects);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, List<StatusEffectInstance> mapStatusEffect) {
        boolean hasPlayerEffect = mapStatusEffect.stream().allMatch(statusEffectInstance -> player.hasStatusEffect(statusEffectInstance.getEffectType()));

        if(!hasPlayerEffect) {
            for (StatusEffectInstance instance : mapStatusEffect) {
                player.addStatusEffect(new StatusEffectInstance(instance.getEffectType(),
                        instance.getDuration(), instance.getAmplifier(), instance.isAmbient(), instance.shouldShowParticles()));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack head  = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack chest = player.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack legs  = player.getEquippedStack(EquipmentSlot.LEGS);
        ItemStack feet  = player.getEquippedStack(EquipmentSlot.FEET);
        return !head.isEmpty() && !chest.isEmpty() && !legs.isEmpty() && !feet.isEmpty();
    }


    private boolean hasCorrectArmorOn(PlayerEntity p) {
        return p.getEquippedStack(EquipmentSlot.HEAD).isOf(AQItems.TURTLE_HELMET)
                && p.getEquippedStack(EquipmentSlot.CHEST).isOf(AQItems.TURTLE_CHESTPLATE)
                && p.getEquippedStack(EquipmentSlot.LEGS).isOf(AQItems.TURTLE_LEGGINGS)
                && p.getEquippedStack(EquipmentSlot.FEET).isOf(AQItems.TURTLE_BOOTS);
    }
}