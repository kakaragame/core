package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.ManagedObject;

import java.util.List;

public interface Chunk extends ManagedObject {
    @NotNull
    List<GameBlock> getGameBlocks();

    @NotNull
    ChunkLocation getLocation();
}
