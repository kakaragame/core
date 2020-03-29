package org.kakara.core.world;

import org.kakara.core.NameKey;

import java.util.Random;

public interface ChunkGenerator {
    String getName();

    NameKey getNameKey();

    ChunkBase generateChunk(int seed, Random r, ChunkBase chunkBase);
}
