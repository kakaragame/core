package org.kakara.core.common.mod.game;


import org.kakara.core.common.GameInstance;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.mod.AbstractMod;

public abstract class GameMod extends AbstractMod {
    public GameInstance getGameInstance() {
        return Kakara.getGameInstance();
    }
}
