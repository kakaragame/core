package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public interface Chunk {
    @NotNull
    List<GameBlock> getGameBlocks();

    @NotNull
    ChunkLocation getLocation();
}
