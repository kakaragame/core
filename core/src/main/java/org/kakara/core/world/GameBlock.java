package org.kakara.core.world;

import org.kakara.core.game.ItemStack;

import java.util.Objects;

public class GameBlock {
    private Location location;
    private ItemStack itemStack;

    public GameBlock(Location location, ItemStack itemStack) {
        this.location = location;
        this.itemStack = itemStack;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameBlock gameBlock = (GameBlock) o;
        return Objects.equals(itemStack, gameBlock.itemStack);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemStack);
    }
}