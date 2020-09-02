package org.kakara.core.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.game.ItemStack;

import java.awt.*;

public abstract class AbstractBoxedInventory extends AbstractInventory implements BoxedInventory {
    public AbstractBoxedInventory(int capacity) {
        super(capacity);
        if ((capacity % rowSize()) != 0) {
            throw new RuntimeException("Capacity must be divisible by " + rowSize());
        }
    }

    public static int pointToIndex(Point point, int rowSize) {
        return (point.y - 1) * rowSize + point.x - 1;
    }

    public abstract int rowSize();

    @Override
    public @NotNull ItemStack getItemStack(@NotNull Point point) {
        return getItemStack(pointToIndex(point, rowSize()));
    }

    @Override
    public void setItemStack(@NotNull ItemStack itemStack, @NotNull Point point) {
        setItemStack(itemStack, pointToIndex(point, rowSize()));
    }
}
