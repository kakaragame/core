package org.kakara.core.crafting;

import org.kakara.core.game.Item;

import java.util.List;
import java.util.Objects;

public class UnshapedCraftingRecipe implements CraftingRecipe {
    private List<Item> itemsRequired;
    private Item item;

    public UnshapedCraftingRecipe(List<Item> itemsRequired, Item item) {
        this.itemsRequired = itemsRequired;
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnshapedCraftingRecipe that = (UnshapedCraftingRecipe) o;
        return Objects.equals(itemsRequired, that.itemsRequired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemsRequired);
    }

    public List<Item> getItemsRequired() {
        return itemsRequired;
    }

    public void setItemsRequired(List<Item> itemsRequired) {
        this.itemsRequired = itemsRequired;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
