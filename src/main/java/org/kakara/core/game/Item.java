package org.kakara.core.game;


import org.kakara.core.events.player.ClickEvent;

public interface Item {
    String getName();

    String getTexture();

    String getId();

    float getWeight();

    void onClick(ClickEvent clickEvent);
}
