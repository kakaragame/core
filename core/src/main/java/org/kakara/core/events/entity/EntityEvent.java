package org.kakara.core.events.entity;

import org.kakara.core.events.Cancellable;
import org.kakara.core.events.Event;
import org.kakara.core.events.HandlerList;
import org.kakara.core.world.GameEntity;

/**
 * This an a GameEntity based event.
 */
public abstract class EntityEvent implements Event, Cancellable {
    private boolean cancelled;
    private GameEntity gameEntity;

    /**
     * @param gameEntity the GameEntity used by the event.
     */
    public EntityEvent(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }

    /**
     * @return the GameEntity used by the event.
     */
    public GameEntity getGameEntity() {
        return gameEntity;
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
