package extrabiomes.meadow.stuff;

import com.google.common.base.Optional;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public enum Element {
	CROP_STRAWBERRY,
	SEED_STRAWBERRY,
	FOOD_CHOCOLATE,
	FOOD_CHOCOLATE_STRAWBERRY;
	
	private Optional<ItemStack> itemStack = Optional.absent();
	
	public ItemStack get() {
		return itemStack.get();
	}
	public boolean isPresent() {
		return itemStack.isPresent();
	}
	
	public void set(ItemStack stack) {
		this.itemStack = Optional.of(stack);
	}
	public void set(Block block, int metadata) {
		this.set(new ItemStack(block, 1, metadata));
	}
	public void set(Block block) {
		this.set(new ItemStack(block, 1));
	}
}
