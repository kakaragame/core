package org.kakara.core.events.entity;

import org.kakara.core.events.HandlerList;
import org.kakara.core.world.GameBlock;
import org.kakara.core.world.GameEntity;

/**
 * This is an event called when a Block is stepped on.
 */
public class StepOnEvent extends EntityEvent {
    private static final HandlerList handlerList = new HandlerList(StepOnEvent.class);
    private final GameBlock blockSteppedOn;

    /**
     * @param gameEntity     the GameEntity used by the event.
     * @param blockSteppedOn the GameBlock which was stepped on.
     */
    public StepOnEvent(GameEntity gameEntity, GameBlock blockSteppedOn) {
        super(gameEntity);
        this.blockSteppedOn = blockSteppedOn;
    }

    public static HandlerList getHandlers() {
        return handlerList;
    }

    /**
     * @return the GameBlock which was stepped on.
     */
    public GameBlock getBlockSteppedOn() {
        return blockSteppedOn;
    }

    @Override
    public HandlerList getHandlerList() {
        return handlerList;
    }
}
