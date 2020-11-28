package org.kakara.core.common.game;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.Identifiable;
import org.kakara.core.common.mod.Mod;

public interface Item extends Identifiable {
    String getName();

    String getTexture();

    String getModel();


    ControllerKey getControllerKey();

    Mod getMod();

    //void onClick(ClickEvent clickEvent);
}
