package org.kakara.core.world;

import java.util.List;

public class ChunkContent {
    private final List<GameBlock> gameBlocks;
    private final ChunkLocation location;

    public ChunkContent(List<GameBlock> gameBlocks, ChunkLocation location) {
        this.gameBlocks = gameBlocks;
        this.location = location;
    }

    public ChunkContent(ChunkLocation location) {
        this.location = location;
        gameBlocks = null;
    }

    public List<GameBlock> getGameBlocks() {
        return gameBlocks;
    }

    public ChunkLocation getLocation() {
        return location;
    }

    public boolean isNullChunk() {
        return gameBlocks == null;
    }
}
