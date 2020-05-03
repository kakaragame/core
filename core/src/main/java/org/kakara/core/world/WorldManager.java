package org.kakara.core.world;

import org.jetbrains.annotations.Nullable;

import java.util.UUID;

public interface WorldManager {
    @Nullable
    World getWorldByUUID(UUID uuid);
}
