package org.kakara.core.common.mod.game;


import org.kakara.core.common.annotations.Hardness;
import org.kakara.core.common.game.Block;
import org.kakara.core.common.mod.Mod;

public abstract class ModBlock extends ModItem implements Block {
    public ModBlock(Mod mod) {
        super(mod);
    }

    @Override
    public float getHardness() {
        Hardness hardness = getClass().getAnnotation(Hardness.class);
        return hardness == null ? 0.0f : hardness.value();
    }
}
