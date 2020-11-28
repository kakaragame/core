package org.kakara.core.server.world;

import org.jetbrains.annotations.Nullable;
import org.kakara.core.common.world.World;

import java.util.UUID;

public interface WorldManager {
    @Nullable
    World getWorldByUUID(UUID uuid);
}
