package org.kakara.core.server.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.gui.container.BoxedInventoryContainer;
import org.kakara.core.common.gui.container.InventoryContainer;

import java.awt.*;

public interface ServerBoxedInventoryContainer extends InventoryContainer, BoxedInventoryContainer {
    void setItemStack(@NotNull ItemStack itemStack, @NotNull Point point);

}
