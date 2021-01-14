package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.game.Entity;

public interface GameEntity {
    @NotNull
    Location getLocation();

    boolean isLiving();



    /**
     * If this is a Player it will return Player
     *
     * @return what type of entity this is.
     */
    @NotNull
    Entity getEntityType();
}
