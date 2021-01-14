package org.kakara.core.server.gui;

import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.gui.container.InventoryContainer;

public interface ServerInventoryContainer extends InventoryContainer {

    void setItemStack(int pos, ItemStack itemStack);

    void addItemStack(ItemStack itemStack);

    void deleteItemStack(int pos);
}
