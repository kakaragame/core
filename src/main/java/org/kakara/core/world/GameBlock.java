package org.kakara.core.world;

import org.kakara.core.game.ItemStack;

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
}