package org.kakara.core.common.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.ItemStack;

public interface Inventory extends Iterable<ItemStack>, Menu {
    @NotNull
    ItemStack getItemStack(int index);

    int getSize();

    @NotNull
    ItemStack[] getContents();

    void redraw();

    InventoryRenderer getRenderer();
}
