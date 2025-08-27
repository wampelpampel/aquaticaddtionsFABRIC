package net.wampel.aq.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.wampel.aq.blocks.AQBlocks;

import java.util.concurrent.CompletableFuture;

public class LootTableProvider extends FabricBlockLootTableProvider {
    public LootTableProvider(FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) {
        super(out, reg);
    }

    @Override
    public void generate() {
        addDrop(AQBlocks.TURTLE_BLOCK);
        addDrop(AQBlocks.SCUTE_BLOCK);
    }
}
