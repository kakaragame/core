package org.kakara.core.game.gui;

public interface InventoryRenderer {

    void render(Inventory inventory);

    void closeInventory();

    void redraw(Inventory inventory);

    InventoryProperties getProperties();
}
