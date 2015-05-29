package extrabiomes.meadow.biomes;

import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.ColorizerFoliage;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.Height;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary.Type;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.meadow.stuff.BiomeCollection;
import extrabiomes.lib.worldgen.ExtrabiomeGenBase;

public class BiomeMeadow extends ExtrabiomeGenBase {

	public BiomeMeadow() {
		super(BiomeCollection.MEADOW.settings, Type.PLAINS);
		setBiomeName("Meadow");
		setHeight(ExtrabiomeGenBase.height_FlatPlains);
		
		this.temperature = BiomeGenBase.plains.temperature;
		this.rainfall = BiomeGenBase.plains.rainfall;
		this.theBiomeDecorator.treesPerChunk = 0;
		
		spawnableCreatureList.add(new SpawnListEntry(EntityHorse.class, 6, 2, 6));
	}
	
    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return ColorizerFoliage.getFoliageColor(1.0F, 1.0F);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return ColorizerGrass.getGrassColor(1.0F, 1.0F);
    }

}
