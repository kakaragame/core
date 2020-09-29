package org.kakara.core.game;


import org.kakara.core.ControllerKey;
import org.kakara.core.Identifiable;
import org.kakara.core.events.player.click.ClickEvent;
import org.kakara.core.mod.Mod;

public interface Item extends Identifiable {
    String getName();

    String getTexture();

    String getModel();


    ControllerKey getControllerKey();

    Mod getMod();

    void onClick(ClickEvent clickEvent);
}
