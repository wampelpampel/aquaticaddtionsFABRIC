package net.wampel.aq.datagen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.*;
import net.minecraft.item.equipment.EquipmentAssetKeys;
import net.minecraft.util.Identifier;
import net.wampel.aq.blocks.AQBlocks;
import net.wampel.aq.items.AQArmorMaterials;
import net.wampel.aq.items.AQItems;
import net.minecraft.util.Identifier;

public class ModelProvider extends FabricModelProvider {

    public ModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(AQBlocks.SCUTE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(AQBlocks.TURTLE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.registerArmor(
                AQItems.VTURTLE_CHESTPLATE,
                AQArmorMaterials.AQ_TURTLE_ARMOR_MATERIAL_KEY,
                Identifier.ofVanilla("trims/items/helmet_trim"),
                false
        );
        itemModelGenerator.registerArmor(
                AQItems.VTURTLE_LEGGINGS,
                AQArmorMaterials.AQ_TURTLE_ARMOR_MATERIAL_KEY,
                Identifier.ofVanilla("trims/items/helmet_trim"),
                false
        );
        itemModelGenerator.registerArmor(
                AQItems.VTURTLE_BOOTS,
                AQArmorMaterials.AQ_TURTLE_ARMOR_MATERIAL_KEY,
                Identifier.ofVanilla("trims/items/helmet_trim"),
                false
        );
        itemModelGenerator.registerArmor(
                AQItems.TURTLE_HELMET,
                AQArmorMaterials.AQ_TURTLE_MASTER_ARMOR_MATERIAL_KEY,
                Identifier.ofVanilla("trims/items/helmet_trim"),
                false
        );
        itemModelGenerator.registerArmor(
                AQItems.TURTLE_CHESTPLATE,
                AQArmorMaterials.AQ_TURTLE_MASTER_ARMOR_MATERIAL_KEY,
                Identifier.ofVanilla("trims/items/helmet_trim"),
                false
        );
        itemModelGenerator.registerArmor(
                AQItems.TURTLE_LEGGINGS,
                AQArmorMaterials.AQ_TURTLE_MASTER_ARMOR_MATERIAL_KEY,
                Identifier.ofVanilla("trims/items/helmet_trim"),
                false
        );
        itemModelGenerator.registerArmor(
                AQItems.TURTLE_BOOTS,
                AQArmorMaterials.AQ_TURTLE_MASTER_ARMOR_MATERIAL_KEY,
                Identifier.ofVanilla("trims/items/helmet_trim"),
                false
        );

        itemModelGenerator.register(AQItems.TURTLE_INGOT, Models.GENERATED);
        itemModelGenerator.register(AQItems.TURTLE_MASTER_UPGRADE_TEMPLATE, Models.GENERATED);

    }

    @Override public String getName() { return "AQ Model Provider"; }
}
