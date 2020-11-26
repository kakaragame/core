package org.kakara.core.game.game;

import org.kakara.core.game.events.entity.StepOnEvent;
import org.kakara.core.game.events.player.PlaceEvent;

public interface Block extends Item {
    void onStep(StepOnEvent event);

    void onPlace(PlaceEvent event);

    float getHardness();
}
