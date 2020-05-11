package org.kakara.core.world.region;

import org.kakara.core.NameKey;
import org.kakara.core.game.Entity;
import org.kakara.core.world.ChunkLocation;
import org.kakara.core.world.GameBlock;

import java.util.List;
import java.util.Random;

public interface Region {
    String getName();

    NameKey getNameKey();

    Entity[] getEntitySpawns();

    List<GameBlock> generate(ChunkLocation chunkLocation, int x, int groundHeight, int z, long seed, Random random);
}