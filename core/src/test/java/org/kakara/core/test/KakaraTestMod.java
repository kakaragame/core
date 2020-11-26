package org.kakara.core.test;

import org.kakara.core.EnvType;
import org.kakara.core.annotations.Environment;
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
    @Environment(EnvType.SERVER)
    public void serverGeneralLoad() {

    }

    @LoadingStage
    @Environment(EnvType.CLIENT)
    public void clientGeneralLoad() {

    }

}
