package net.wampel.aq.items;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.wampel.aq.AQ;

import java.util.Map;
import net.minecraft.item.equipment.EquipmentAsset;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.item.equipment.EquipmentType;

public class AQArmorMaterials {

    public static final int TURTLE_BASE_DURABILITY = 15;
    public static final TagKey<Item> REPAIRS_SCUTE = ItemTags.;
    public static final RegistryKey<EquipmentAsset> AQ_TURTLE_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(AQ.MOD_ID, "aq_turtle"));

    public static final ArmorMaterial AQ_TURTLE_INSTANCE = new ArmorMaterial(
            TURTLE_BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_SCUTE,
            AQ_TURTLE_ARMOR_MATERIAL_KEY
    );

    public static final int TURTLE_MASTER_BASE_DURABILITY = 15;
    public static final TagKey<Item> REPAIRS_TURTLE_INGO = AQItems.TURTLE_INGOT;
    public static final RegistryKey<EquipmentAsset> AQ_TURTLE_MASTER_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(AQ.MOD_ID, "aq_turtle"));

    public static final ArmorMaterial AQ_TURTLE_MASTER_INSTANCE = new ArmorMaterial(
            TURTLE_BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_IRON,
            0.0F,
            0.0F,
            REPAIRS_SCUTE,
            AQ_TURTLE_ARMOR_MATERIAL_KEY
    );

}