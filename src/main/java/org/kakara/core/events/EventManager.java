package org.kakara.core.events;

import org.kakara.core.GameInstance;
import org.kakara.core.mod.LoadStage;
import org.kakara.core.mod.Mod;

public interface EventManager extends LoadStage {

    void registerEventHandler(Object handler, Mod mod);

    void callEvent(Event event);

    void load(GameInstance GameInstance);

}
