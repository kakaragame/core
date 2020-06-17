package org.kakara.core.gui;

public interface InventoryManager {
    /**
     * Creates a new InventoryBased
     *
     * @param inventoryClass This can either be the Builder class or the Inventory class it's self
     * @param <T>            The InventoryBuilder Type
     * @return a new instance of the InventoryBuilder
     */
    <T extends InventoryBuilder> T createInventory(Class<?> inventoryClass);
}
