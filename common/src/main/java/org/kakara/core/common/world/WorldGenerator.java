package org.kakara.core.common.world;


import org.kakara.core.common.Identifiable;

import java.util.Random;

public interface WorldGenerator extends Identifiable {

    ChunkBase generateChunk(int seed, Random random, World world, int x, int y, int z);
}
