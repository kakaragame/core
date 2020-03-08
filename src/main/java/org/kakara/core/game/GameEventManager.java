package org.kakara.core.game;

import me.kingtux.simpleannotation.MethodFinder;
import org.kakara.core.KakaraCore;
import org.kakara.core.events.Cancallable;
import org.kakara.core.events.Event;
import org.kakara.core.events.EventHandlerObject;
import org.kakara.core.events.EventManager;
import org.kakara.core.events.annotations.EventHandler;
import org.kakara.core.mod.Mod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameEventManager implements EventManager {
    private List<EventHandlerObject> registeredEventHandler = new ArrayList<>();
    private KakaraCore kakaraCore;

    @Override
    public void registerEventHandler(Object handler, Mod mod) {
        Method[] methods = MethodFinder.getAllMethodsWithAnnotation(handler.getClass(), EventHandler.class, false);
        for (Method method : methods) {

            Class<?> param = method.getParameters()[0].getType();
            if (!param.isAssignableFrom(Event.class) || method.getParameters().length != 1) {
                KakaraCore.LOGGER.warn(String.format("Unable to register %s dulse to not taking an event.", method.getName()));
                continue;
            }
            registeredEventHandler.add(new EventHandlerObject(method, (Class<? extends Event>) param, mod, handler));
        }
    }

    @Override
    public void callEvent(Event event) {
        List<EventHandlerObject> eventHandlers = registeredEventHandler.stream().filter(eventHandlerObject -> {
            return event.getClass() == eventHandlerObject.getEventType();
        }).collect(Collectors.toList());

        for (EventHandlerObject e : eventHandlers) {
            if (event instanceof Cancallable) {
                if (((Cancallable) event).isCancelled()) break;
            }
            e.invokeEvent(event);
        }

    }

    @Override
    public void load(KakaraCore kakaraCore) {
        this.kakaraCore = kakaraCore;
    }
}
