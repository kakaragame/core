package org.kakara.core.common.game;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.GameObject;
import org.kakara.core.common.Identifiable;
import org.kakara.core.common.mod.Mod;

public interface Item extends Identifiable, GameObject {
    String getName();

    String getTexture();

    String getModel();


    ControllerKey getControllerKey();

    Mod getMod();


    //void onClick(ClickEvent clickEvent);
}
