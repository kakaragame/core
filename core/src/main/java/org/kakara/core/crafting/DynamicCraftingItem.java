package org.kakara.core.crafting;

import org.kakara.core.game.Item;
import org.kakara.core.game.ItemStack;

import java.util.Objects;

/**
 * This represents a CraftingItem which can be recognized with any instance of a specific class.
 * e.g. If MyItem extends AItem (which would extend Item), you create a new DynamicCraftingItem with AItem.class, and it would except any sub-class of it, MyItem being one of them.
 */
public class DynamicCraftingItem implements CraftingItem {
    private int x;
    private int y;
    private Class<? extends Item> baseClass;

    /**
     * @param x the x coordinate of this item in the CraftingRecipe.
     * @param y the y coordinate of this item in the CraftingRecipe.
     * @param baseClass the Item base Class which other items would extend (generally abstract).
     */
    public DynamicCraftingItem(int x, int y, Class<? extends Item> baseClass) {
        this.x = x;
        this.y = y;
        this.baseClass = baseClass;
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
        return itemStack.getClass().isAssignableFrom(baseClass);
    }

    /**
     * @return the Item base Class which other items would extend (generally abstract).
     */
    public Class<? extends Item> getBaseClass() {
        return baseClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicCraftingItem that = (DynamicCraftingItem) o;
        return x == that.x &&
                y == that.y &&
                that.baseClass.isAssignableFrom(baseClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, baseClass);
    }
}
