package org.kakara.core.game;

import org.kakara.core.KakaraCore;
import org.kakara.core.events.Event;
import org.kakara.core.events.EventHandlerObject;
import org.kakara.core.events.EventManager;
import org.kakara.core.mod.Mod;

import java.util.ArrayList;
import java.util.List;

public class GameEventManager implements EventManager {
    private List<EventHandlerObject> registeredEventHandler = new ArrayList<>();
    private KakaraCore kakaraCore;

    @Override
    public void registerEventHandler(Object handler, Mod mod) {
//TODO setup registerEventHandler
    }

    @Override
    public void callEvent(Event event) {
//TODO setupCallEvent
    }

    @Override
    public void load(KakaraCore kakaraCore) {
        this.kakaraCore = kakaraCore;
    }
}
