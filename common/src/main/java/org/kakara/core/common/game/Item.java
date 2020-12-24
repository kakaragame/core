package org.kakara.core.common.game;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.GameObject;
import org.kakara.core.common.Identifiable;
import org.kakara.core.common.game.md.ModelData;
import org.kakara.core.common.mod.Mod;

public interface Item extends Identifiable, GameObject {
    String getName();

    @Deprecated
    String getTexture();

    @Deprecated
    String getModel();

    ModelData getModelData();

    ControllerKey getControllerKey();

    Mod getMod();


    //void onClick(ClickEvent clickEvent);
}
