package org.kakara.core.game.gui.events;

import org.kakara.core.game.events.player.PlayerEvent;
import org.kakara.core.game.gui.Menu;
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
