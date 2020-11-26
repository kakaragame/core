package org.kakara.core.game.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.game.Entity;

public interface GameEntity {
    @NotNull
    Location getLocation();

    boolean isLiving();

    boolean kill();

    void teleport(@NotNull Location location);

    /**
     * If this is a Player it will return Player
     *
     * @return what type of entity this is.
     */
    @NotNull
    Entity getEntityType();
}
