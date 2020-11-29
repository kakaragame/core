package org.kakara.core.common.game;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.GameObject;
import org.kakara.core.common.Identifiable;
import org.kakara.core.common.events.Listener;
import org.kakara.core.common.events.RegisteredListener;
import org.kakara.core.common.mod.Mod;

import java.util.Set;

public interface Item extends Identifiable, GameObject {
    String getName();

    String getTexture();

    String getModel();


    ControllerKey getControllerKey();

    Mod getMod();


    //void onClick(ClickEvent clickEvent);
}
