package net.wampel.aq.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wampel.aq.AQ;
import net.wampel.aq.blocks.ModBlocks;

public class AQItemGroups {
    public static final RegistryKey<ItemGroup> AQ_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(AQ.MOD_ID, "aq_group"));
    public static final ItemGroup AQ_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            AQ_ITEM_GROUP_KEY,
            FabricItemGroup.builder()
                            .displayName(Text.translatable("itemgroup.aq"))
                            .icon(() -> new ItemStack(AQItems.TURTLE_INGOT)).entries(
                                    ((displayContext, entries) -> {
                                        entries.add(AQItems.TURTLE_INGOT);
                                        entries.add(ModBlocks.TURTLE_BLOCK);
                                        entries.add(ModBlocks.SCUTE_BLOCK);
                                        entries.add(AQItems.TURTLE_APPLE);
                                        entries.add(AQItems.GOLD_FISH);
                                        entries.add(AQItems.TURTLE_SWORD);
                                        entries.add(AQItems.TURTLE_PICKAXE);
                                        entries.add(AQItems.TURTLE_AXE);
                                        entries.add(AQItems.TURTLE_SHOVEL);
                                        entries.add(AQItems.TURTLE_HOE);
                                        entries.add(AQItems.VTURTLE_CHESTPLATE);
                                        entries.add(AQItems.VTURTLE_LEGGINGS);
                                        entries.add(AQItems.VTURTLE_BOOTS);
                                        entries.add(AQItems.TURTLE_HELMET);
                                        entries.add(AQItems.TURTLE_CHESTPLATE);
                                        entries.add(AQItems.TURTLE_LEGGINS);
                                        entries.add(AQItems.TURTLE_BOOTS);

                                    })
                            ).build());

    public static void registerItemGroups() {
        //dummy method for static initialization
    }
}
