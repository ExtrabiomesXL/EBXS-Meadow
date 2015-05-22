package extrabiomes.meadow.handlers;

import java.util.List;

import net.minecraft.item.ItemStack;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.lib.items.ExtraItem;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.lib.settings.BlockSettings;
import extrabiomes.lib.worldgen.ExtraWorldGenerator;
import extrabiomes.lib.worldgen.ExtrabiomeGenBase;
import extrabiomes.lib.worldgen.WorldGenDecoration;
import extrabiomes.lib.worldgen.WorldGenWildflower;
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
		final ExtraWorldGenerator gen = new ExtraWorldGenerator(12);
		gen.registerBiome(meadowSettings);
        GameRegistry.registerWorldGenerator(gen, 20);
		
		final BlockExtraFlower block = new BlockExtraFlower();
		GameRegistry.registerBlock(block, ExtraItem.class, "meadow.flower");
		
		List<ItemStack> flowerStacks = Lists.newArrayList();
		for( BlockExtraFlower.BlockType type : BlockExtraFlower.BlockType.values() ) {
			meadowBiome.addFlower(block, type.metadata, type.weight);
			flowerStacks.add(new ItemStack(block, 1, type.metadata));
		}
		
		gen.registerGenerator("wildflower", new WorldGenWildflower(flowerStacks));
		
		// TODO: register with Forestry
	}

}
