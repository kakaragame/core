package org.kakara.core.world.region;

import org.kakara.core.game.Entity;
import org.kakara.core.world.Structure;


public interface Region {
    String getName();

    Structure[] getStructures();

    GenerationLayer[] getLayers();

    Entity[] getEntitySpawns();

    AboveBlock[] getAboveBlocks();

    int getPrecipitationChance();

    int getHeatLevel();

    int getMinimumY();

    int getMaximumY();
}
