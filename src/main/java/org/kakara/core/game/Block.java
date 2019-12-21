package org.kakara.core.game;

import org.kakara.core.events.PlaceEvent;
import org.kakara.core.events.StepOnEvent;

public interface Block extends Item {

    void onStep(StepOnEvent event);

    void onPlace(PlaceEvent event);

    float getHardness();
}
