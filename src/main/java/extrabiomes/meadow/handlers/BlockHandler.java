package extrabiomes.meadow.handlers;

import java.util.List;

import net.minecraft.item.ItemStack;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.registry.GameRegistry;
import extrabiomes.lib.blocks.BlockExtraCrop;
import extrabiomes.lib.items.ExtraItem;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.lib.settings.BlockSettings;
import extrabiomes.lib.worldgen.ExtraWorldGenerator;
import extrabiomes.lib.worldgen.ExtrabiomeGenBase;
import extrabiomes.lib.worldgen.WorldGenWildflower;
import extrabiomes.meadow.Version;
import extrabiomes.meadow.blocks.BlockCropStrawberry;
import extrabiomes.meadow.blocks.BlockMeadowFlower;
import extrabiomes.meadow.stuff.BiomeCollection;
import extrabiomes.meadow.stuff.BlockCollection;
import extrabiomes.meadow.stuff.Element;

public abstract class BlockHandler {

	public static void init() {
		createFlowers();
		createCrops();
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
		
		final BlockMeadowFlower block = new BlockMeadowFlower();
		GameRegistry.registerBlock(block, ExtraItem.class, "meadow.flower");
		
		List<ItemStack> flowerStacks = Lists.newArrayList();
		for( BlockMeadowFlower.BlockType type : BlockMeadowFlower.BlockType.values() ) {
			meadowBiome.addFlower(block, type.metadata, type.weight);
			flowerStacks.add(new ItemStack(block, 1, type.metadata));
		}
		
		gen.registerGenerator("wildflower", new WorldGenWildflower(flowerStacks));
		
		// TODO: register with Forestry
	}
	
	private static void createCrops() {
		final BlockSettings settings = BlockCollection.STRAWBERRY.settings;
		if( !settings.isEnabled() ) return;
		
		// TODO: create crop & seed items
		
		final Element plant = Element.PLANT_STRAWBERRY;
		final Element crop = Element.CROP_STRAWBERRY;
		
		final BlockExtraCrop block = new BlockCropStrawberry();
		if( crop.isPresent() )
			block.setCropItem(crop.get().getItem());
		block.setBlockName(Version.LOC_PREFIX+".crop.strawberry");
		
		// TODO: swap out correct item class
		GameRegistry.registerBlock(block, ExtraItem.class, "meadow.strawberry");
	
		// TODO: register bonemeal handler
		
		plant.set(block);
	}

}
