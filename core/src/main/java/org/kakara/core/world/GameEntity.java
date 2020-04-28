package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.game.Entity;

public interface GameEntity {
    @NotNull
    Location getLocation();

    void teleport(@NotNull Location location);

    /**
     * If this is a Player it will return Player
     *
     * @return what type of entity this is.
     */
    @NotNull
    Entity getEntityType();
}
