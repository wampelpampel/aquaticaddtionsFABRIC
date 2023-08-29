package net.wampel.aq.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.wampel.aq.AQ;
import net.wampel.aq.blocks.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup AQ_GROUP =
            Registry.register(Registries.ITEM_GROUP,
                    new Identifier(AQ.MOD_ID, "aq"),
                    FabricItemGroup.builder().displayName(Text.translatable
                            ("itemgroup.aq"))
                            .icon(() -> new ItemStack(ModItems.TURTLE_INGOT)).entries(
                                    ((displayContext, entries) -> {
                                        entries.add(ModItems.TURTLE_INGOT);
                                        entries.add(ModBlocks.TURTLE_BLOCK);
                                        entries.add(ModBlocks.SCUTE_BLOCK);
                                        entries.add(ModItems.DIAMOND_NUGGET);
                                        entries.add(ModItems.TURTLE_APPLE);
                                        entries.add(ModItems.GOLD_FISH);
                                        entries.add(ModItems.TURTLE_SWORD);
                                        entries.add(ModItems.TURTLE_PICKAXE);
                                        entries.add(ModItems.TURTLE_AXE);
                                        entries.add(ModItems.TURTLE_SHOVEL);
                                        entries.add(ModItems.TURTLE_HOE);
                                        entries.add(ModItems.VTURTLE_CHESTPLATE);
                                        entries.add(ModItems.VTURTLE_LEGGINS);
                                        entries.add(ModItems.VTURTLE_BOOTS);
                                        entries.add(ModItems.TURTLE_HELMET);
                                        entries.add(ModItems.TURTLE_CHESTPLATE);
                                        entries.add(ModItems.TURTLE_LEGGINS);
                                        entries.add(ModItems.TURTLE_BOOTS);

                                    })
                            ).build());
    public static void regusterItemGroups() {
        AQ.LOGGER.info("Register item groups for" + AQ.MOD_ID);
    }
}
