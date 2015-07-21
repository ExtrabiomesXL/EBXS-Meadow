package extrabiomes.meadow.blocks;

import java.util.ArrayList;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import extrabiomes.lib.blocks.BlockExtraCrop;
import extrabiomes.lib.blocks.IBlockTypeCrop;
import extrabiomes.lib.blocks.IBlockTypeCrop.CropType;
import extrabiomes.lib.settings.CropSettings;
import extrabiomes.meadow.Meadow;
import extrabiomes.meadow.Version;

public class BlockCropStrawberry extends BlockExtraCrop {

	public BlockCropStrawberry() {
		super( Meadow.instance, Version.LOC_PREFIX,
				new CropSettings("strawberry", CropType.REGROW) );
	}

}
