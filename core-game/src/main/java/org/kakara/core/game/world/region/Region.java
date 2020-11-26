package org.kakara.core.game.world.region;

import org.kakara.core.Identifiable;
import org.kakara.core.game.Entity;
import org.kakara.core.world.ChunkLocation;
import org.kakara.core.world.GameBlock;

import java.util.List;
import java.util.Random;

public interface Region extends Identifiable {

    Entity[] getEntitySpawns();

    List<GameBlock> generate(ChunkLocation chunkLocation, int x, int y, int z, int groundHeight, int seed, Random random);
}