package org.kakara.core.gui.events;

import org.kakara.core.gui.Inventory;
import org.kakara.core.player.Player;

public abstract class InventoryEvent extends MenuEvent {
    private final Inventory inventory;

    public InventoryEvent(Player player, Inventory menu) {
        super(player, menu);
        this.inventory = menu;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
