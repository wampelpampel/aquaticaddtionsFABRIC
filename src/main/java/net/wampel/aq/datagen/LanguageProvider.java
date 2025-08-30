package net.wampel.aq.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class LanguageProvider extends FabricLanguageProvider {
    public LanguageProvider(FabricDataOutput out, CompletableFuture<RegistryWrapper.WrapperLookup> reg) {
        super(out, "en_us", reg);
    }


    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add("item.aq.turtle_ingot", "Turtle Master Ingot");
        translationBuilder.add("item.aq.turtle_crafting_upgrade", "Turtle Master Crafting Upgrade");
        translationBuilder.add("block.aq.scute_block", "Scute Block");
        translationBuilder.add("item.aq.scute_block", "Scute Block");
        translationBuilder.add("itemGroup.aq", "Aquatic Additions");
        translationBuilder.add("block.aq.turtle_block", "Turtle Block");
        translationBuilder.add("item.aq.turtle_block", "Block of the Turtle Master");
        translationBuilder.add("item.aq.vturtle_chestplate", "Turtle Chestplate");
        translationBuilder.add("item.aq.vturtle_leggings", "Turtle Leggings");
        translationBuilder.add("item.aq.vturtle_boots", "Turtle Boots");
        translationBuilder.add("item.aq.turtle_helmet", "Helmet of the Turtle Master");
        translationBuilder.add("item.aq.turtle_chestplate", "Chestplate of the Turtle Master");
        translationBuilder.add("item.aq.turtle_leggings", "Leggings of the Turtle Master");
        translationBuilder.add("item.aq.turtle_boots", "Boots of the Turtle Master");
    }
}
