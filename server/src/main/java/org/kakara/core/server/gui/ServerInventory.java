package org.kakara.core.server.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.gui.Inventory;

public interface ServerInventory extends Inventory {
    void addItemStack(@NotNull ItemStack itemStack);

    void setItemStack(@NotNull ItemStack itemStack, int index);

    void clear();
}
