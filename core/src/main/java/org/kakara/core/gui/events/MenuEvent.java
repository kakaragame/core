package org.kakara.core.gui.events;

import org.kakara.core.events.player.PlayerEvent;
import org.kakara.core.gui.Menu;
import org.kakara.core.player.Player;

public abstract class MenuEvent extends PlayerEvent {
    private final Menu menu;

    public MenuEvent(Player player, Menu menu) {
        super(player);
        this.menu = menu;
    }

    public Menu getMenu() {
        return menu;
    }
}
