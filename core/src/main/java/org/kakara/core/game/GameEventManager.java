package org.kakara.core.game;

import me.kingtux.simpleannotation.MethodFinder;
import org.kakara.core.GameInstance;
import org.kakara.core.Kakara;
import org.kakara.core.events.*;
import org.kakara.core.events.annotations.EventHandler;
import org.kakara.core.events.player.Listener;
import org.kakara.core.mod.Mod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameEventManager implements EventManager {
    private GameInstance GameInstance;

    @Override
    public void registerEventHandler(Listener handler, Mod mod) {
        Method[] methods = MethodFinder.getAllMethodsWithAnnotation(handler.getClass(), EventHandler.class, false);
        for (Method method : methods) {

        }
    }

    @Override
    public void callEvent(Event event) {
        for (RegisteredListener registeredListener : event.getHandlerList().getListenerList()) {

        }
    }

    @Override
    public void load(GameInstance GameInstance) {
        this.GameInstance = GameInstance;
    }


    @Override
    public Class<?> getStageClass() {
        return EventManager.class;
    }
}
