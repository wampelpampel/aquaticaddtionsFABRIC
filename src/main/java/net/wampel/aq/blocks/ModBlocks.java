package net.wampel.aq.blocks;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.wampel.aq.AQ;

public class ModBlocks {

    public static final Block TURTLE_BLOCK = registerBlock("turtle_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block SCUTE_BLOCK = registerBlock("scute_block",
            new Block(FabricBlockSettings.copyOf(Blocks.LAPIS_BLOCK)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK,
                new Identifier(AQ.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(
                AQ.MOD_ID, name
        ), new BlockItem(block, new FabricItemSettings()));
    }
    public static void registerModBlocks() {
        AQ.LOGGER.info("Registering Mod blocks for" + AQ.MOD_ID);
    }
}
