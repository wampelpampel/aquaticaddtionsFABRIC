package net.wampel.aq.items;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.wampel.aq.AQ;

import java.util.Map;

public class AQArmorMaterials {

    public static final int TURTLE_BASE_DURABILITY = ArmorMaterials.IRON.durability(); //15 is equivalent to iron armor
    private static final TagKey<Item> REPAIRS_SCUTE = ItemTags.REPAIRS_TURTLE_HELMET;
    private static final float TURTLE_TOUGHNESS = 0;
    private static final float TURTLE_KNOCKBACK_RESISTANCE = 0F;
    public static final RegistryKey<EquipmentAsset> AQ_TURTLE_ARMOR_MATERIAL_KEY =     RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(AQ.MOD_ID, "vturtle"));

    public static final ArmorMaterial AQ_TURTLE_INSTANCE = new ArmorMaterial(
            TURTLE_BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 0,
                    EquipmentType.CHESTPLATE, 6,
                    EquipmentType.LEGGINGS, 5,
                    EquipmentType.BOOTS, 2
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,
            TURTLE_TOUGHNESS,
            TURTLE_KNOCKBACK_RESISTANCE,
            REPAIRS_SCUTE,
            AQ_TURTLE_ARMOR_MATERIAL_KEY
    );


    public static final int TURTLE_MASTER_BASE_DURABILITY = ArmorMaterials.NETHERITE.durability();
    private static final TagKey<Item> REPAIRS_TURTLE_INGOT = TagKey.of(RegistryKeys.ITEM, Identifier.of(AQ.MOD_ID, "turtle_ingot"));
    public static final RegistryKey<EquipmentAsset> AQ_TURTLE_MASTER_ARMOR_MATERIAL_KEY = RegistryKey.of(EquipmentAssetKeys.REGISTRY_KEY, Identifier.of(AQ.MOD_ID, "turtle_master"));
    public static final float TURTLE_MASTER_TOUGHNESS = 2F;
    private static final float TURTLE_MASTER_KNOCKBACKRESSISTANCE = 0.15F;

    public static final ArmorMaterial AQ_TURTLE_MASTER_INSTANCE = new ArmorMaterial(
            TURTLE_MASTER_BASE_DURABILITY,
            Map.of(
                    EquipmentType.HELMET, 3,
                    EquipmentType.CHESTPLATE, 8,
                    EquipmentType.LEGGINGS, 6,
                    EquipmentType.BOOTS, 3
            ),
            5,
            SoundEvents.ITEM_ARMOR_EQUIP_TURTLE,
            TURTLE_MASTER_TOUGHNESS,
            TURTLE_MASTER_KNOCKBACKRESSISTANCE,
            REPAIRS_TURTLE_INGOT,
            AQ_TURTLE_MASTER_ARMOR_MATERIAL_KEY
    );

}