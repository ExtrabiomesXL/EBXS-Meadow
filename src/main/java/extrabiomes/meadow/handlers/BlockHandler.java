package extrabiomes.meadow.handlers;

import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.lib.items.ExtraItem;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.lib.settings.BlockSettings;
import extrabiomes.lib.worldgen.ExtraWorldGenerator;
import extrabiomes.lib.worldgen.ExtrabiomeGenBase;
import extrabiomes.lib.worldgen.WorldGenDecoration;
import extrabiomes.meadow.blocks.BlockExtraFlower;
import extrabiomes.meadow.stuff.BiomeCollection;
import extrabiomes.meadow.stuff.BlockCollection;

public abstract class BlockHandler {

	public static void init() {
		createFlowers();
		/// createCrops();
	}

	private static void createFlowers() {
		final BlockSettings settings = BlockCollection.FLOWER.settings;
		if( !settings.isEnabled() ) return;
		
		final BiomeSettings meadowSettings = BiomeCollection.MEADOW.settings;
		final ExtrabiomeGenBase meadowBiome = meadowSettings.getBiome().get();
		
		// max of 8 attempts per chunk << TODO: make configurable
		final ExtraWorldGenerator gen = new ExtraWorldGenerator(8);
		gen.registerBiome(meadowSettings);
        GameRegistry.registerWorldGenerator(gen, 50);
		
		final BlockExtraFlower block = new BlockExtraFlower();
		GameRegistry.registerBlock(block, ExtraItem.class, "meadow.flower");
		
		for( BlockExtraFlower.BlockType type : BlockExtraFlower.BlockType.values() ) {
			meadowBiome.addFlower(block, type.metadata, type.weight);
			gen.registerGenerator(type.name(), new WorldGenDecoration(block, type.metadata));
		}
		
		// TODO: register with Forestry
	}

}
