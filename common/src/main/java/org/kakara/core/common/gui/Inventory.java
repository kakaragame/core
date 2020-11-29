package org.kakara.core.common.gui;

import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.gui.container.InventoryContainer;

/**
 * When creating a custom Inventory please call GameInstance.getContainerUtils().createInventoryContainer
 */
public interface Inventory extends Iterable<ItemStack>, Menu {

    int getSize();

    void redraw();

    InventoryRenderer getRenderer();

    InventoryContainer getContainer();

    /**
     * For internal use only.
     * <p>
     * Calling on the client wont do anything. It will just reset that value.
     * Calling on the server will change the values. But it wont be safe.
     */
    void setInventoryContainer(InventoryContainer inventoryContainer);
}
