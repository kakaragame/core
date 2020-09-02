package org.kakara.core.crafting;

import org.kakara.core.game.ItemStack;

import java.util.List;
import java.util.Objects;

/**
 * This represents a CraftingItem which is a list of possible ItemStacks a recipe can accept.
 */
public class StaticCraftingItem implements CraftingItem {
    private final int x;
    private final int y;
    private final List<ItemStack> itemStacks;

    /**
     * @param x          the x coordinate of this item in the CraftingRecipe.
     * @param y          the y coordinate of this item in the CraftingRecipe.
     * @param itemStacks the list items which the recipe can accept as valid.
     */
    public StaticCraftingItem(int x, int y, List<ItemStack> itemStacks) {
        this.x = x;
        this.y = y;
        this.itemStacks = itemStacks;
    }

    private static boolean hasMatchingItemStack(List<ItemStack> list, List<ItemStack> list2) {
        for (ItemStack itemStack : list) {
            if (list2.contains(itemStack)) return true;
        }

        return false;
    }

    /**
     * @return the x coordinate of this item in the CraftingRecipe.
     */
    @Override
    public int getX() {
        return x;
    }

    /**
     * @return the y coordinate of this item in the CraftingRecipe.
     */
    @Override
    public int getY() {
        return y;
    }

    /**
     * @param itemStack the ItemStack to match
     * @return is the inputted ItemStack compatible with this crafting item?
     */
    @Override
    public boolean matches(ItemStack itemStack) {
        return itemStacks.contains(itemStack);
    }

    /**
     * @return the list of items which the recipe can accept as valid.
     */
    public List<ItemStack> getItemStacks() {
        return itemStacks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaticCraftingItem that = (StaticCraftingItem) o;
        return x == that.x &&
                y == that.y &&
                hasMatchingItemStack(itemStacks, that.itemStacks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, itemStacks);
    }
}
