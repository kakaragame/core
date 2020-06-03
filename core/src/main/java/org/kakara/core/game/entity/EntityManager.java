package org.kakara.core.game.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.NameKey;
import org.kakara.core.game.Entity;
import org.kakara.core.game.Item;
import org.kakara.core.mod.LoadStage;
import org.kakara.core.world.WorldGenerator;

import java.util.Optional;

public interface EntityManager extends LoadStage {

    void registerEntity(@NotNull Entity entity);

    Optional<Entity> getEntity(int id);

    default Optional<Entity> getEntity(String entity) {
        return getEntity(new NameKey(entity.toLowerCase()));
    }

    default Optional<Entity> getEntity(NameKey entity) {
        return getEntity(entity.hashCode());
    }

}
