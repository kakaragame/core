package org.kakara.core.world;

import org.kakara.core.NameKey;

import java.util.Random;

public interface WorldGenerator {
    String getName();

    NameKey getNameKey();

    ChunkBase generateChunk(int seed, Random random, World world, int x, int y, int z);
}
