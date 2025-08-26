package net.wampel.aq.items;

import net.minecraft.item.Item;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.wampel.aq.AQ;

import java.util.function.Function;

public class AQItems {

    //Helper method from fabric documentation
    //creates an item instance and registers it
    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(AQ.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }

    public static final Item TURTLE_INGOT = registerItem("turtle_ingot", Item::new, new Item.Settings());

    //Turtle Armor
    public static final Item VTURTLE_CHESTPLATE = registerItem("vturtle_chestplate",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(AQArmorMaterials.TURTLE_BASE_DURABILITY))
                    .armor(AQArmorMaterials.AQ_TURTLE_INSTANCE, EquipmentType.CHESTPLATE)
    );
    public static final Item VTURTLE_LEGGINGS = registerItem("vturtle_leggings",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.LEGGINGS.getMaxDamage(AQArmorMaterials.TURTLE_BASE_DURABILITY))
                    .armor(AQArmorMaterials.AQ_TURTLE_INSTANCE, EquipmentType.LEGGINGS)
    );
    public static final Item VTURTLE_BOOTS = registerItem("vturtle_boots",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(AQArmorMaterials.TURTLE_BASE_DURABILITY))
                    .armor(AQArmorMaterials.AQ_TURTLE_INSTANCE, EquipmentType.BOOTS)
    );

    //Turtle Master armor
    public static final Item TURTLE_HELMET = registerItem("turtle_helmet",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(AQArmorMaterials.TURTLE_MASTER_BASE_DURABILITY))
                    .armor(AQArmorMaterials.AQ_TURTLE_MASTER_INSTANCE, EquipmentType.HELMET));
    public static final Item TURTLE_CHESTPLATE = registerItem("turtle_chestplate",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.CHESTPLATE.getMaxDamage(AQArmorMaterials.TURTLE_MASTER_BASE_DURABILITY))
                    .armor(AQArmorMaterials.AQ_TURTLE_MASTER_INSTANCE, EquipmentType.LEGGINGS));
    public static final Item TURTLE_LEGGINGS = registerItem("turtle_leggings",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.HELMET.getMaxDamage(AQArmorMaterials.TURTLE_MASTER_BASE_DURABILITY))
                    .armor(AQArmorMaterials.AQ_TURTLE_MASTER_INSTANCE, EquipmentType.HELMET));
    public static final Item TURTLE_BOOTS = registerItem("turtle_boots",
            Item::new,
            new Item.Settings().maxDamage(EquipmentType.BOOTS.getMaxDamage(AQArmorMaterials.TURTLE_MASTER_BASE_DURABILITY))
                    .armor(AQArmorMaterials.AQ_TURTLE_MASTER_INSTANCE, EquipmentType.BOOTS));

    //Dummy method to statically inititalize the class
    public static void initialize() {
        //Dummy mehtod
    }
}
