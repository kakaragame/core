package org.kakara.core.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.game.ItemStack;

public interface Inventory extends Iterable<ItemStack> {
    @NotNull
    ItemStack getItemStack(int index);

    int getSize();

    @NotNull
    ItemStack[] getContents();

    void addItemStack(@NotNull ItemStack itemStack);

    void setItemStack(@NotNull ItemStack itemStack, int index);
}
