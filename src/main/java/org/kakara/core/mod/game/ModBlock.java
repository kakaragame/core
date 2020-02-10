package org.kakara.core.mod.game;

import org.kakara.core.annotations.Hardness;
import org.kakara.core.annotations.Weight;
import org.kakara.core.game.Block;
import org.kakara.core.mod.Mod;

public abstract class ModBlock extends ModItem implements Block{
    public ModBlock(Mod mod) {
        super(mod);
    }

    @Override
    public float getHardness() {
        Hardness hardness = getClass().getAnnotation(Hardness.class);
        return hardness == null ? 0.0f : hardness.value();
    }
}
