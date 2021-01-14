package org.kakara.core.common.game.entity;

import org.kakara.core.common.game.Entity;
import org.kakara.core.common.world.Location;

public interface GamePath {

    Location[] getRoute();

    /**
     * IDK
     *
     * @param entity the entity to move
     * @param speed  the speed
     */
    @Deprecated
    void moveEntityAlongRoute(Entity entity, float speed);

}
