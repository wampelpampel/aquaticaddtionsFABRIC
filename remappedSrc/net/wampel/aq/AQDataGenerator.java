package net.wampel.aq;

import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.loader.api.FabricLoader;
import net.wampel.aq.datagen.*;

public class AQDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
	//	pack.addProvider(TagProvider::new);
		pack.addProvider(LanguageProvider::new);
		pack.addProvider(RecipeProvider::new);
		pack.addProvider(ModelProvider::new);
		pack.addProvider(LootTableProvider::new);
	}
}
