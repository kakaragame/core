package org.kakara.core.mod.game;

import org.kakara.core.game.Tool;
import org.kakara.core.mod.Mod;

public abstract class ModTool extends ModItem implements Tool {
    public ModTool(Mod mod) {
        super(mod);
    }
}
