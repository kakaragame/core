package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.ManagedObject;

import java.util.List;

public interface Chunk extends ManagedObject {
    @NotNull
    List<GameBlock> getGameBlocks();

    @NotNull
    ChunkLocation getLocation();
}
