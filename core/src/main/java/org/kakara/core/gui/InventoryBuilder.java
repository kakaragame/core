package org.kakara.core.gui;

public interface InventoryBuilder<T extends Inventory> {
    T build();
}
