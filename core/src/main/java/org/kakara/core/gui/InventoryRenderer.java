package org.kakara.core.gui;

public interface InventoryRenderer {

    void render(Inventory inventory);

    void closeInventory();

    void redraw(Inventory inventory);
}
