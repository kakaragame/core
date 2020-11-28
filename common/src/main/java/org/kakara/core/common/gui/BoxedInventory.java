package org.kakara.core.common.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.ItemStack;

import java.awt.*;

//This could be renamed
public interface BoxedInventory extends Inventory {
    @NotNull
    ItemStack getItemStack(@NotNull Point point);

    void setItemStack(@NotNull ItemStack itemStack, @NotNull Point point);
}
