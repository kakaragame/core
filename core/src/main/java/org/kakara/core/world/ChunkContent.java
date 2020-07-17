package org.kakara.core.world;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChunkContent that = (ChunkContent) o;
        return Objects.equals(getLocation(), that.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLocation());
    }
}
