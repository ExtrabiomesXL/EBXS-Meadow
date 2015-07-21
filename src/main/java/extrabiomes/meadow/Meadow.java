package extrabiomes.meadow;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.google.common.collect.ImmutableList;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.lib.BiomeUtils;
import extrabiomes.lib.Const;
import extrabiomes.lib.IEBXSSubMod;
import extrabiomes.lib.ModBase;
import extrabiomes.lib.settings.BiomeSettings;
import extrabiomes.meadow.handlers.BlockHandler;
import extrabiomes.meadow.handlers.ConfigurationHandler;
import extrabiomes.meadow.handlers.ItemHandler;
import extrabiomes.meadow.handlers.RecipeHandler;
import extrabiomes.meadow.proxy.CommonProxy;
import extrabiomes.meadow.stuff.BiomeCollection;
import extrabiomes.meadow.stuff.BlockCollection;

@Mod(modid = Version.MOD_ID, name = Version.MOD_NAME, version = Version.VERSION, 
	dependencies = "required-after:"+Const.API_MOD_ID)
public class Meadow extends ModBase implements IEBXSSubMod
{
    public Meadow() {
		super(Version.MOD_ID);
	}
    
	@Instance(Version.MOD_ID)
    public static Meadow instance;
    
    @SidedProxy(clientSide = Version.CLIENT_PROXY, serverSide = Version.SERVER_PROXY)
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        basePreInit(event);
        
        BiomeCollection.init();
        BlockCollection.init();
        ConfigurationHandler.init(Config);
        
        BiomeUtils.register(this, Version.API_VERSION);
    }
    
    public void ebxsPreInit() {
    	super.ebxsPreInit();
    	BlockHandler.init();
    	ItemHandler.init();
    	/// CropHandler.init();
    }
    
    public void ebxsInit() {
    	super.ebxsInit();
    	LOGGER.info("Loaded version %s, API version %s", Version.VERSION, Version.API_VERSION);
    	proxy.registerRenderInformation();
    }
    
    public void ebxsPostInit() {
    	super.ebxsPostInit();
    	RecipeHandler.init();
    }

	public List<BiomeSettings> getBiomeSettings() {
		return BiomeCollection.allSettings;
	}

    private List<Class<? extends IWorldGenerator>> worldGens = ImmutableList.of();
	public List<Class<? extends IWorldGenerator>> getWorldGenerators() {
		return worldGens;
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon registerIcon(IIconRegister iconRegister, String texture) {
		IIcon icon = iconRegister.registerIcon(Version.TEXTURE_PATH + texture);
		return icon;
	}

}
