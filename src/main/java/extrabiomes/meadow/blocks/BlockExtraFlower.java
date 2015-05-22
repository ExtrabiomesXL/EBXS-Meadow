package extrabiomes.meadow.blocks;

import java.util.List;
import java.util.Locale;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import extrabiomes.meadow.Meadow;
import extrabiomes.meadow.Version;
import extrabiomes.lib.blocks.IExtraBlock;

public class BlockExtraFlower extends BlockFlower implements IExtraBlock {

	public enum BlockType {
		HYDRANGEA(0, 2, "hydrangea", 12),
		BUTTERCUP(1, 5, "buttercup", 11),
		BACHELORS_BUTTON(2, 3, "bachelorsbutton_blue", 4),
		DAISY(3, 3, "daisy", 15),
		DANDELION(4, 3, "dandelion", -1),
		GERBERA_ORANGE(5, 3, "gerbera_orange", 14),
		GERBERA_PINK(6, 3, "gerbera_pink", 9),
		GERBERA_RED(7, 3, "gerbera_red", 1),
		GERBERA_YELLOW(8, 3, "gerbera_yellow", 11),
		YARROW(9, 3, "yarrow", 11);
		
		public final int	metadata;
		public final int	weight;
		public final int	color;
		
		public final String	texture;
		
		private BlockType(int metadata, int weight, String texture, int color) {
			this.metadata = metadata;
			this.weight = weight;
			this.texture = texture;
			this.color = color;
		}
		
		private IIcon icon;
		public IIcon getIcon() {
			return icon;
		}
		
		@SideOnly(Side.CLIENT)
		public IIcon registerIcon(IIconRegister iconRegister) {
			icon = iconRegister.registerIcon(Version.TEXTURE_PATH + this.texture);
			return icon;
		}
		
		public static BlockType getBlockType(int metadata) {
			if( metadata < 0 || metadata > BlockType.values().length )
				return null;
			return BlockType.values()[metadata];
		}
	}
	
	// NB: may need to switch to a generic block manually implementing IPlantable
	public BlockExtraFlower() {
		super(0);
		setBlockName(Version.LOC_PREFIX+".flower");
		setTickRandomly(true);
		setHardness(0.0f);
		setStepSound(Block.soundTypeGrass);
		// TODO: add our own tab again
		setCreativeTab(CreativeTabs.tabDecorations);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs tab, List itemList) {
		for( final BlockType type : BlockType.values() ) {
			itemList.add(new ItemStack(this, 1, type.metadata));
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		Meadow.LOGGER.debug(this.getClass().getSimpleName() + ": registerIcons");
		for( BlockType type : BlockType.values() ) {
			final IIcon icon = type.registerIcon(iconRegister);
			if( icon == null ) {
				Meadow.LOGGER.warn("No icon found for %s (%d)", type, type.metadata);
			} else {
				Meadow.LOGGER.debug("%s: %s = %s", this.getClass().getSimpleName(), type, icon);
			}
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		final BlockType type = BlockType.getBlockType(metadata);
		if( type != null ) {
			return type.getIcon();
		} else {
			return null;
		}
	}

	public String getUnlocalizedName(int metadata) {
		if( metadata < 0 || metadata > BlockType.values().length )
			return null;
		final BlockType type = BlockType.values()[metadata];
		if( type != null ) {
			return this.getUnlocalizedName() + "." + type.name().toLowerCase(Locale.ENGLISH);
		} else {
			return "";
		}
	}
	
}
