package org.kakara.core.game;

import org.kakara.core.events.entity.StepOnEvent;
import org.kakara.core.events.player.PlaceEvent;

public interface Block extends Item {

    void onStep(StepOnEvent event);

    void onPlace(PlaceEvent event);

    float getHardness();
}
