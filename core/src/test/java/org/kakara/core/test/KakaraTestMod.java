package org.kakara.core.test;

import org.kakara.core.GameTypes;
import org.kakara.core.annotations.GameType;
import org.kakara.core.game.ItemManager;
import org.kakara.core.game.entity.EntityManager;
import org.kakara.core.mod.annotations.LoadingStage;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.world.WorldGenerationManager;

public class KakaraTestMod extends GameMod {
    @LoadingStage
    public void loadItems(ItemManager manager) {

    }

    @LoadingStage
    public void loadWorldGen(WorldGenerationManager manager) {

    }

    @LoadingStage
    public void loadEntitys(EntityManager manager) {

    }

    @LoadingStage
    @GameType(GameTypes.SERVER)
    public void serverGeneralLoad() {

    }

    @LoadingStage
    @GameType(GameTypes.CLIENT)
    public void clientGeneralLoad() {

    }

}
