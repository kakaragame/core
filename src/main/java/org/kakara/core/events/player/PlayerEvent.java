package org.kakara.core.events.player;

import org.kakara.core.events.Event;
import org.kakara.core.player.Player;

/**
 * Events that are executed because a Player Did something
 */
public class PlayerEvent implements Event {
    private Player player;

    public PlayerEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
