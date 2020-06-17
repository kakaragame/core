package org.kakara.core.gui;

public interface InventoryManager {

    <T extends InventoryBuilder> T createInventory(Class<?> inventoryClass);
}
