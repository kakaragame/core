package org.kakara.core.events;

import org.kakara.core.GameInstance;
import org.kakara.core.mod.Mod;

public interface EventManager {

    void registerEventHandler(Object handler, Mod mod);

    void callEvent(Event event);

    void load(GameInstance GameInstance);

}
