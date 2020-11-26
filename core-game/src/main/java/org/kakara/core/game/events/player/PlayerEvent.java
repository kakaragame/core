package org.kakara.core.game.events.player;

import org.kakara.core.events.Cancellable;
import org.kakara.core.events.Event;
import org.kakara.core.player.Player;

/**
 * This an a Player based event.
 */
public class PlayerEvent implements Event, Cancellable {
    private boolean cancelled;
    private final Player player;

    /**
     * @param player the Player used by the event.
     */
    public PlayerEvent(Player player) {
        this.player = player;
    }

    /**
     * @return the Player used by the event.
     */
    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
