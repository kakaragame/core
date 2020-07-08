package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.Status;

import java.util.List;

public interface Chunk {
    @NotNull
    List<GameBlock> getGameBlocks();

    @NotNull
    ChunkLocation getLocation();

    Status getStatus();
}
