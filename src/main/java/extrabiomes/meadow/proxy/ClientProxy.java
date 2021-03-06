package extrabiomes.meadow.proxy;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    public static final Minecraft MC	= Minecraft.getMinecraft();

	@Override
    public int registerBlockHandler(ISimpleBlockRenderingHandler handler)
    {
        final int renderId = RenderingRegistry.getNextAvailableRenderId();
        RenderingRegistry.registerBlockHandler(renderId, handler);
        return renderId;
    }
}
