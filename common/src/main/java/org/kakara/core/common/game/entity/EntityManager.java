package org.kakara.core.common.game.entity;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.game.Entity;
import org.kakara.core.common.mod.LoadStage;

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
