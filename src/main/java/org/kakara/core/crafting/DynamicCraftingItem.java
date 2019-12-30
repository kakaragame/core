package org.kakara.core.crafting;

import org.kakara.core.game.Item;

import java.util.Objects;

public class DynamicCraftingItem implements CraftingItem {
    private int x;
    private int y;
    private Class<? extends Item> itemToExtend;

    public DynamicCraftingItem(int x, int y, Class<? extends Item> itemToExtend) {
        this.x = x;
        this.y = y;
        this.itemToExtend = itemToExtend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DynamicCraftingItem that = (DynamicCraftingItem) o;
        return x == that.x &&
                y == that.y &&
                that.itemToExtend.isAssignableFrom(itemToExtend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, itemToExtend);
    }

    @Override
    public int getX() {
        return y;
    }

    @Override
    public int getY() {
        return y;
    }
}
