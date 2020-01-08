package org.kakara.core.world;

import org.kakara.core.game.Block;
import org.kakara.core.game.Entity;


public interface Region {
    interface Structure {
        String getName();

        Schematic getSchematic();

        // false, it's like a bush or a rock pile
        // true, it's like
        boolean isCommendable();

        ChunkGenerator.RegionFlag[] getRegionFlags();

        // 0-100 value, 0 being rare, 100 being like rocks, you find them everywhere
        int getRarity();
    }

    class AboveBlock {
        private Block under, above;
        private int chance;

        public AboveBlock(Block under, Block above, int chance) {
            this.under = under;
            this.above = above;
            this.chance = chance;
        }

        public Block getUnder() {
            return under;
        }

        public Block getAbove() {
            return above;
        }

        public int getChance() {
            return chance;
        }
    }

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
