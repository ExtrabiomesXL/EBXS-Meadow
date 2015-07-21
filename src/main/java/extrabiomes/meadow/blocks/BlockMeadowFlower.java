package extrabiomes.meadow.blocks;

import net.minecraft.util.IIcon;
import extrabiomes.lib.blocks.BlockExtraFlower;
import extrabiomes.lib.blocks.IBlockTypeFlower;
import extrabiomes.meadow.Meadow;
import extrabiomes.meadow.Version;

public class BlockMeadowFlower extends BlockExtraFlower {

	public enum BlockType implements IBlockTypeFlower {
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
		public void setIcon(IIcon icon) {
			this.icon = icon;
		}

		@Override
		public int getMeta() {
			return metadata;
		}

		@Override
		public int getWeight() {
			return weight;
		}

		@Override
		public int getColor() {
			return color;
		}
		
		@Override
		public String getTexture() {
			return texture;
		}
	}
	
	// NB: may need to switch to a generic block manually implementing IPlantable
	public BlockMeadowFlower() {
		super(Meadow.instance, Version.LOC_PREFIX, BlockType.values());
	}
}
