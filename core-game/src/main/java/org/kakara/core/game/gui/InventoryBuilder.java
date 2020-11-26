package org.kakara.core.game.gui;

public interface InventoryBuilder<T extends Inventory> {
    T build();
}
