package extrabiomes.meadow.handlers;

import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapelessRecipes;

public class RecipeHandler {

	public static void init() {
		
	}
	
	
	private static void addRecipe(IRecipe recipe) {
		CraftingManager.getInstance().getRecipeList().add(0, recipe);
	}

}
