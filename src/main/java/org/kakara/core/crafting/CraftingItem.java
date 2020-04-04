package org.kakara.core.crafting;

import org.kakara.core.game.ItemStack;

/**
 * This represents an item used in a CraftingRecipe.
 */
public interface CraftingItem {
    /**
     * @return the x coordinate of this item in the CraftingRecipe.
     */
    int getX();

    /**
     * @return the y coordinate of this item in the CraftingRecipe.
     */
    int getY();

    /**
     * @param itemStack the ItemStack to match
     * @return does the ItemStack match the requirements of this CraftingItem
     */
    boolean matches(ItemStack itemStack);
}
