package org.kakara.core.crafting;

import org.kakara.core.game.Item;

import java.util.List;

public interface CraftingManager {

    List<CraftingRecipe> getRecipesForItem(Item item);

    List<CraftingRecipe> getAllCraftingRecipes();

    CraftingRecipe getRecipeForRecipe(CraftingRecipe recipe);
}
