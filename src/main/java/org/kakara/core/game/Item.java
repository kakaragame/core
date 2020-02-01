package org.kakara.core.game;


import org.kakara.core.events.player.ClickEvent;
import org.kakara.core.mod.Mod;

public interface Item {
    String getName();

    String getTexture();

    String getModel();

    String getId();

    Mod getMod();

    float getWeight();

    void onClick(ClickEvent clickEvent);
}
