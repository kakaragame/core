package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.LoadableObject;

import java.util.List;

public interface Chunk extends LoadableObject {
    @NotNull
    List<GameBlock> getGameBlocks();

    @NotNull
    ChunkLocation getLocation();
}
