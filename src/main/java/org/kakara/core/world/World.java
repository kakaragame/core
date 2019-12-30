package org.kakara.core.world;

import java.util.List;
import java.util.UUID;

public interface World {

    Chunk[] getChunks();

    UUID getUUID();

    String getName();

    GameBlock getBlockAt(int x, int y, int z);

    GameBlock getBlockAt(Location location);

    Chunk getChunkAt(int x, int z);

    Chunk getChunkAt(Location location);

    void loadChunk(Chunk chunk);

    boolean isChunkLoaded(int x, int z);

    Chunk[] getLoadedChunks();
}
