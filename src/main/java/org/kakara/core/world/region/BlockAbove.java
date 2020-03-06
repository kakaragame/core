package org.kakara.core.world.region;

import org.kakara.core.game.Block;

public class BlockAbove {
    private Block under, above;
    private int chance;

    public BlockAbove(Block under, Block above, int chance) {
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
