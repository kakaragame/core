package org.kakara.core.world.region;

import org.kakara.core.game.Block;
import org.kakara.core.game.Entity;
import org.kakara.core.world.ChunkGenerator;
import org.kakara.core.world.Schematic;
import org.kakara.core.world.Structure;


public interface Region {


    String getName();

    Structure[] getStructures();

    // maybe implement rarity somehow
    Entity[] getEntitySpawns();

    // like adding grass to dirt, or adding dead bushes to sand
    AboveBlock[] getAboveBlocks();

    // 0, never
    // 1-99, chance of raining
    // 100, always raining
    // 101-199, chance of snowing
    // 200, always snowing
    int getPrecipitationChance();

    int getHeatLevel();

    int getMinimumY();

    int getMaximumY();
}
