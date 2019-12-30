package org.kakara.core.world;

import org.kakara.core.game.Entity;

public interface GameEntity {
    Location getLocation();

    /**
     * If this is a Player it will return Player
     *
     * @return what type of entity this is.
     */
    Entity getEntityType();
}
