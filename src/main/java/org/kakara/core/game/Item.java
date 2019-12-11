package org.kakara.core.game;

import org.kakara.core.events.ClickEvent;

public interface Item {
    String getName();

    String getTexture();

    String getId();


    void onClick(ClickEvent clickEvent);
}
