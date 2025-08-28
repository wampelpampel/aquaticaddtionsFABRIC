package net.wampel.aq.items;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.wampel.aq.AQ;

public class AQTags {
    public static final TagKey<Item> SMELLY_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.tryParse(AQ.MOD_ID, "repairs_turtle_master"));

}
