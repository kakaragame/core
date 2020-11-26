package org.kakara.core.game.world;

import org.kakara.core.Identifiable;

import java.util.Random;

public interface WorldGenerator extends Identifiable {

    ChunkBase generateChunk(int seed, Random random, World world, int x, int y, int z);
}
