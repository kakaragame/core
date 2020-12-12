package org.kakara.core.common.mod.game;

import org.kakara.core.common.EnvTypeable;
import org.kakara.core.common.mod.AbstractModManager;
import org.kakara.core.common.mod.Mod;

public class GameModManager extends AbstractModManager {

    public GameModManager(Mod coreMod) {
        super(coreMod);
    }

    @Override
    public void load(EnvTypeable typeable) {
        super.load(typeable);
        modLoader = new GameModLoader();
    }
}
