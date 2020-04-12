package org.kakara.core.crafting;

import org.kakara.core.game.ItemStack;

import java.util.List;

/**
 * This is used to manage crafting recipes on a GameInstance.
 */
public interface CraftingManager {
    /**
     * @param itemStack the ItemStack for which you want to find recipes.
     * @return all the crafting recipes which have a result of the inputted ItemStack.
     */
    List<CraftingRecipe> getRecipesForItemStack(ItemStack itemStack);

    /**
     * @return all the crafting recipes.
     */
    List<CraftingRecipe> getAllCraftingRecipes();
}
