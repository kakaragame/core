package org.kakara.core.game.gui.events;

import org.kakara.core.game.gui.Inventory;
import org.kakara.core.player.Player;

public class InventoryEvent extends MenuEvent {
    private final Inventory inventory;

    public InventoryEvent(Player player, Inventory menu) {
        super(player, menu);
        this.inventory = menu;
    }

    public Inventory getInventory() {
        return inventory;
    }
}
