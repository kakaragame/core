package org.kakara.core.game.events;

public interface Cancellable {
    boolean isCancelled();

    /**
     * Sets whether the event is cancelled or not
     *
     * @param b the status
     */
    void setCancelled(boolean b);
}
