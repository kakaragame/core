package org.kakara.core.crafting;

import org.kakara.core.game.Item;

import java.util.List;
import java.util.Objects;

public class StaticCraftingItem implements CraftingItem{
    private int x;
    private int y;
    private List<Item> item;


    public StaticCraftingItem(int x, int y, List<Item> item) {
        this.x = x;
        this.y = y;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StaticCraftingItem that = (StaticCraftingItem) o;
        return x == that.x &&
                y == that.y &&
               Utils.hasMatchingItem(item,that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, item);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public List<Item> getItems() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }
}
