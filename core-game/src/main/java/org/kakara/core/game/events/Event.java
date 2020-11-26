package org.kakara.core.game.events;

/**
 * A base for all Kakara events to implement.
 */
public interface Event {
    /**
     * @return the name of the Event.
     */
    default String getName() {
        return getClass().getSimpleName();
    }
}
