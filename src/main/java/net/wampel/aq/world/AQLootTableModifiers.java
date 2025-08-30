package net.wampel.aq.world;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;

import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;

/*
Turtle Scute in:
 * buried treasure chest 100% 3-9
 * shipwreck
    * supply 50% 2-4
    * treasure 50% 3-6
 * fishing junk 20%

Nautilus Shells in:
 * ocean ruins
    * supply 25% 2-4
    * big 50% 2-4
 */


public class AQLootTableModifiers {
    public static void registerLootTables() {
        LootTableEvents.MODIFY.register((RegistryKey<LootTable> key,
                                         LootTable.Builder tableBuilder,
                                         LootTableSource source,
                                         RegistryWrapper.WrapperLookup registries) -> {
            if (key.equals(LootTables.BURIED_TREASURE_CHEST)) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.TURTLE_SCUTE).weight(1))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(3.0f, 9.0f)));
                tableBuilder.pool(pool);
            }
            if (key.equals(LootTables.SHIPWRECK_TREASURE_CHEST)) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.TURTLE_SCUTE)
                                .weight(1)
                                .conditionally(RandomChanceLootCondition.builder(0.5f))
                        )
                        .apply(SetCountLootFunction.builder(
                                UniformLootNumberProvider.create(3.0f, 6.0f)
                        ));
                tableBuilder.pool(pool);
            }
            if (key.equals(LootTables.SHIPWRECK_SUPPLY_CHEST)) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.TURTLE_SCUTE)
                                .weight(1)
                                .conditionally(RandomChanceLootCondition.builder(0.5f))
                        )
                        .apply(SetCountLootFunction.builder(
                                UniformLootNumberProvider.create(2.0f, 4.0f)
                        ));
                tableBuilder.pool(pool);
            }
            if (key.equals(LootTables.FISHING_JUNK_GAMEPLAY)) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.TURTLE_SCUTE)
                                .conditionally(RandomChanceLootCondition.builder(0.25f))
                        )
                        .apply(SetCountLootFunction.builder(
                                UniformLootNumberProvider.create(1.0f, 1.0f)
                        ));

                tableBuilder.pool(pool);
            }
            if (key.equals(LootTables.UNDERWATER_RUIN_BIG_CHEST) || key.equals(LootTables.UNDERWATER_RUIN_SMALL_CHEST)) {
                LootPool.Builder pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .with(ItemEntry.builder(Items.NAUTILUS_SHELL)
                                .conditionally(RandomChanceLootCondition.builder(0.5f))
                        )
                        .apply(SetCountLootFunction.builder(
                                UniformLootNumberProvider.create(2.0f, 4.0f)
                        ));

                tableBuilder.pool(pool);
            }
        });
    }
}