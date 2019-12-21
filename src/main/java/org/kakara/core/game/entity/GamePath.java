package org.kakara.core.game.entity;

import org.kakara.core.game.Entity;
import org.kakara.core.game.Location;

public interface GamePath {

    Location[] getRoute();

    /**
     * IDK
     * @param entity the entity to move
     * @param speed the speed
     */
    @Deprecated
    void moveEntityAlongRoute(Entity entity, float speed);

}
