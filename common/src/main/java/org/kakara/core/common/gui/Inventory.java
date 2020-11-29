package org.kakara.core.common.gui;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.gui.container.InventoryContainer;

public interface Inventory extends Iterable<ItemStack>, Menu {

    int getSize();

    void redraw();

    InventoryRenderer getRenderer();

    InventoryContainer getContainer();
}
