package org.kakara.core.common.mod.game;


import org.kakara.core.common.mod.AbstractMod;
import org.kakara.core.common.mod.AbstractModLoader;

public class GameModLoader extends AbstractModLoader {

    @Override
    protected Class<?> requiredClass() {
        return GameMod.class;
    }

    @Override
    protected void postSetup(AbstractMod abstractMod) {
//TODO implement This
    }
}
