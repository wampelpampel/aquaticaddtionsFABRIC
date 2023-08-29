package net.wampel.aq.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wampel.aq.AQ;

public class ModItems {

    //Simple Items
    public static final Item TURTLE_INGOT = registerItem("turtle_ingot", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_NUGGET = registerItem("diamond_nugget", new Item(new FabricItemSettings()));

    //Food Items
    public static final Item TURTLE_APPLE = registerItem("turtle_apple",
            new Item(new FabricItemSettings().food(ModFoodComponents.TURTLE_APPLE)));

    public static final Item GOLD_FISH = registerItem("golden_fish",
            new Item(new FabricItemSettings().food(ModFoodComponents.GOLDEN_FISH)));

    //Turtle tools
    public static final Item TURTLE_SWORD = registerItem("turtle_sword",
            new SwordItem(ModToolMaterial.TURTLE, 3, -2.6F, new FabricItemSettings()));
    public static final Item TURTLE_PICKAXE = registerItem("turtle_pickaxe",
            new PickaxeItem(ModToolMaterial.TURTLE, 1, -2.1F, new FabricItemSettings()));
    public static final Item TURTLE_AXE = registerItem("turtle_axe",
            new SwordItem(ModToolMaterial.TURTLE, 5, -3.1F, new FabricItemSettings()));
    public static final Item TURTLE_SHOVEL = registerItem("turtle_shovel",
            new SwordItem(ModToolMaterial.TURTLE, 2, -3.3F, new FabricItemSettings()));
    public static final Item TURTLE_HOE = registerItem("turtle_hoe",
            new SwordItem(ModToolMaterial.TURTLE, -4, -0.5F, new FabricItemSettings()));

    //Armor
    public static final Item VTURTLE_CHESTPLATE = registerItem("vturtle_chestplate",
            new VTurtleModArmorItem(ModArmorMaterials.VTURTLE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item VTURTLE_LEGGINS = registerItem("vturtle_leggins",
            new ArmorItem(ModArmorMaterials.VTURTLE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item VTURTLE_BOOTS = registerItem("vturtle_boots",
            new ArmorItem(ModArmorMaterials.VTURTLE, ArmorItem.Type.BOOTS, new FabricItemSettings()));


    public static final Item TURTLE_HELMET = registerItem("turtle_helmet",
            new TurtleModArmorItem(ModArmorMaterials.TURTLE, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item TURTLE_CHESTPLATE = registerItem("turtle_chestplate",
            new ArmorItem(ModArmorMaterials.TURTLE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item TURTLE_LEGGINS = registerItem("turtle_leggins",
            new ArmorItem(ModArmorMaterials.TURTLE, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item TURTLE_BOOTS = registerItem("turtle_boots",
            new ArmorItem(ModArmorMaterials.TURTLE, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    //Helper methods
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(AQ.MOD_ID, name), item);
    }
    public static void registerModItems() {
        AQ.LOGGER.info("Registering Items for " + AQ.MOD_ID);
    }
}
