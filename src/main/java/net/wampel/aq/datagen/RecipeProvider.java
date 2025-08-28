package net.wampel.aq.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import net.wampel.aq.AQ;
import net.wampel.aq.blocks.AQBlocks;
import net.wampel.aq.items.AQItems;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {
    public RecipeProvider(FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) {
        super(out, reg);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter exporter) {
        return new RecipeGenerator(wrapperLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                // === TURTLE BLOCK (aus Ingots) ===
                createShaped(RecipeCategory.MISC, AQBlocks.TURTLE_BLOCK)
                        .pattern("BBB")
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', AQItems.TURTLE_INGOT)
                        .criterion(hasItem(AQItems.TURTLE_INGOT), conditionsFromItem(AQItems.TURTLE_INGOT))
                        .offerTo(exporter);

                // === SCUTE BLOCK ===
                createShaped(RecipeCategory.MISC, AQBlocks.SCUTE_BLOCK)
                        .pattern("BBB")
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', Items.TURTLE_SCUTE)
                        .criterion(hasItem(Items.TURTLE_SCUTE), conditionsFromItem(Items.TURTLE_SCUTE))
                        .offerTo(exporter);

                // === VTURTLE (Scute-Rüstung) ===
                createShaped(RecipeCategory.COMBAT, AQItems.VTURTLE_CHESTPLATE)
                        .pattern("B B")
                        .pattern("BBB")
                        .pattern("BBB")
                        .input('B', Items.TURTLE_SCUTE)
                        .criterion(hasItem(Items.TURTLE_SCUTE), conditionsFromItem(Items.TURTLE_SCUTE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, AQItems.VTURTLE_LEGGINGS)
                        .pattern("BBB")
                        .pattern("B B")
                        .pattern("B B")
                        .input('B', Items.TURTLE_SCUTE)
                        .criterion(hasItem(Items.TURTLE_SCUTE), conditionsFromItem(Items.TURTLE_SCUTE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, AQItems.VTURTLE_BOOTS)
                        .pattern("   ")
                        .pattern("B B")
                        .pattern("B B")
                        .input('B', Items.TURTLE_SCUTE)
                        .criterion(hasItem(Items.TURTLE_SCUTE), conditionsFromItem(Items.TURTLE_SCUTE))
                        .offerTo(exporter);

                // === TURTLE MASTER (erweiterte Rüstung aus Ingots) ===
                createShaped(RecipeCategory.COMBAT, AQItems.TURTLE_HELMET)
                        .pattern("III")
                        .pattern("IHI")
                        .pattern("   ")
                        .input('I', AQItems.TURTLE_INGOT)
                        .input('H', Items.TURTLE_HELMET) // Vanilla Turtle Helmet als Kern
                        .criterion(hasItem(AQItems.VTURTLE_CHESTPLATE), conditionsFromItem(AQItems.VTURTLE_CHESTPLATE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, AQItems.TURTLE_CHESTPLATE)
                        .pattern("IPI")
                        .pattern("ICI")
                        .pattern("III")
                        .input('I', AQItems.TURTLE_INGOT)
                        .input('C', Items.CONDUIT)
                        .input('P', AQItems.VTURTLE_CHESTPLATE) // Basis aus Scute
                        .criterion(hasItem(AQItems.VTURTLE_CHESTPLATE), conditionsFromItem(AQItems.VTURTLE_CHESTPLATE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, AQItems.TURTLE_LEGGINGS)
                        .pattern("III")
                        .pattern("IHI")
                        .pattern("I I")
                        .input('I', AQItems.TURTLE_INGOT)
                        .input('H', AQItems.VTURTLE_LEGGINGS)
                        .criterion(hasItem(AQItems.VTURTLE_CHESTPLATE), conditionsFromItem(AQItems.VTURTLE_CHESTPLATE))
                        .offerTo(exporter);

                createShaped(RecipeCategory.COMBAT, AQItems.TURTLE_BOOTS)
                        .pattern("   ")
                        .pattern("I I")
                        .pattern("IHI")
                        .input('I', AQItems.TURTLE_INGOT)
                        .input('H', AQItems.VTURTLE_BOOTS)
                        .criterion(hasItem(AQItems.VTURTLE_CHESTPLATE), conditionsFromItem(AQItems.VTURTLE_CHESTPLATE))
                        .offerTo(exporter);

                // === Dekomprimieren: Turtle Block -> 9 Ingots ===
                createShapeless(RecipeCategory.MISC, AQItems.TURTLE_INGOT, 9)
                        .input(AQBlocks.TURTLE_BLOCK)
                        .criterion(hasItem(AQItems.TURTLE_INGOT), conditionsFromItem(AQItems.TURTLE_INGOT))
                        .offerTo(exporter);

                // === Turtle Ingot (Shard + Crystals + Gold + Diamond) ===
                createShapeless(RecipeCategory.MISC, AQItems.TURTLE_INGOT)
                        .input(Items.PRISMARINE_SHARD)
                        .input(Items.PRISMARINE_CRYSTALS)
                        .input(Items.GOLD_INGOT)
                        .input(Items.DIAMOND)
                        .criterion(hasItem(AQItems.VTURTLE_CHESTPLATE), conditionsFromItem(AQItems.VTURTLE_CHESTPLATE))
                        .offerTo(exporter, "turtle_ingot_2");

            }
        };
    }

    @Override
    public String getName() {
        return "Recipe Generator";
    }
}
