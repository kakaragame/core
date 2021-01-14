package org.kakara.core.common.gui.container;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.ItemStack;

import java.awt.*;

public interface BoxedInventoryContainer extends InventoryContainer{
    @NotNull
    ItemStack getItemStack(@NotNull Point point);
}
