package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.Loadable;

import java.util.List;

public interface Chunk extends Loadable {
    @NotNull
    List<GameBlock> getGameBlocks();

    @NotNull
    ChunkLocation getLocation();
}
