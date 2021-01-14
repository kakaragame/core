package org.kakara.core.common.world.region;


import org.kakara.core.common.Identifiable;
import org.kakara.core.common.world.ChunkLocation;
import org.kakara.core.common.world.GameBlock;

import java.util.List;
import java.util.Random;

public interface Region extends Identifiable {

    //Entity[] getEntitySpawns();

    List<GameBlock> generate(ChunkLocation chunkLocation, int x, int y, int z, int groundHeight, int seed, Random random);
}