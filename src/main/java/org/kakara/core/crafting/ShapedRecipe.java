package org.kakara.core.crafting;

import org.kakara.core.game.Item;

import java.util.List;
import java.util.Objects;

public class ShapedRecipe implements CraftingRecipe {
    private List<CraftingItem> itemList;
    private Item item;

    public ShapedRecipe(List<CraftingItem> itemList, Item item) {
        this.itemList = itemList;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShapedRecipe that = (ShapedRecipe) o;
        return Objects.equals(itemList, that.itemList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemList, item);
    }
}
