package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.game.ItemStack;

import java.util.Objects;

public class GameBlock {
    @NotNull
    private Location location;
    @NotNull
    private ItemStack itemStack;

    public GameBlock(@NotNull Location location, @NotNull ItemStack itemStack) {
        this.location = location;
        this.itemStack = itemStack;
    }

    @NotNull
    public Location getLocation() {
        return location;
    }

    public void setLocation(@NotNull Location location) {
        this.location = location;
    }

    @NotNull
    public ItemStack getItemStack() {
        return itemStack;
    }

    public void setItemStack(@NotNull ItemStack itemStack) {
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