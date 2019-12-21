package org.kakara.core.events;

import org.kakara.core.player.Player;

public class PlayerEvent implements Event {
    private Player player;

    public Player getPlayer() {
        return player;
    }
}
