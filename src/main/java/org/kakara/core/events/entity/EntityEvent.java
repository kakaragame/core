package org.kakara.core.events.entity;

import org.kakara.core.world.GameEntity;

public class EntityEvent {
    private GameEntity gameEntity;

    public EntityEvent(GameEntity gameEntity) {
        this.gameEntity = gameEntity;
    }

    public GameEntity getGameEntity() {
        return gameEntity;
    }
}
