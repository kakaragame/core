package org.kakara.core.common.gui;

public interface InventoryRenderer {

    void render(Inventory inventory);

    void closeInventory();

    void redraw(Inventory inventory);

    InventoryProperties getProperties();
}
