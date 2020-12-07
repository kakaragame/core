package org.kakara.core.server.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.gui.container.BoxedInventoryContainer;
import org.kakara.core.server.game.ServerItemStack;

import java.awt.*;

public interface ServerBoxedInventoryContainer extends ServerInventoryContainer, BoxedInventoryContainer {
    void setItemStack(@NotNull ItemStack itemStack, @NotNull Point point);

}
