package org.kakara.core.events.entity;


import org.kakara.core.world.GameBlock;
import org.kakara.core.world.GameEntity;

public class StepOnEvent extends EntityEvent {
    private GameBlock blockSteppedOn;


    public StepOnEvent(GameEntity gameEntity, GameBlock blockSteppedOn) {
        super(gameEntity);
        this.blockSteppedOn = blockSteppedOn;
    }

    public GameBlock getBlockSteppedOn() {
        return blockSteppedOn;
    }
}
