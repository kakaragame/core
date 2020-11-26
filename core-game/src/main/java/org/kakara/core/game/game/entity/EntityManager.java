package org.kakara.core.game.game.entity;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.ControllerKey;
import org.kakara.core.game.game.Entity;
import org.kakara.core.mod.LoadStage;

import java.util.Optional;

public interface EntityManager extends LoadStage {

    void registerEntity(@NotNull Entity entity);

    Optional<Entity> getEntity(int id);

    default Optional<Entity> getEntity(String entity) {
        return getEntity(new ControllerKey(entity.toLowerCase()));
    }

    default Optional<Entity> getEntity(ControllerKey entity) {
        return getEntity(entity.hashCode());
    }

}
