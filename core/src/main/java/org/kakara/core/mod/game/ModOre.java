package org.kakara.core.mod.game;

import org.kakara.core.game.Ore;
import org.kakara.core.mod.Mod;

public abstract class ModOre extends ModBlock implements Ore {
    private final int veinSize;
    private final int depth;
    private final int sparsity;
    private final int rarity;

    public ModOre(Mod mod, int veinSize, int depth, int sparsity, int rarity) {
        super(mod);
        this.veinSize = veinSize;
        this.depth = depth;
        this.sparsity = sparsity;
        this.rarity = rarity;
    }

    public int getVeinSize() {
        return veinSize;
    }

    public int getDepth() {
        return depth;
    }

    public int getSparsity() {
        return sparsity;
    }

    public int getRarity() {
        return rarity;
    }
}
