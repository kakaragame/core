package org.kakara.core.game;

import me.kingtux.simpleannotation.MethodFinder;
import org.kakara.core.GameInstance;
import org.kakara.core.Kakara;
import org.kakara.core.events.Cancellable;
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
    private GameInstance GameInstance;

    @Override
    public void registerEventHandler(Object handler, Mod mod) {
        Method[] methods = MethodFinder.getAllMethodsWithAnnotation(handler.getClass(), EventHandler.class, false);
        for (Method method : methods) {

            Class<?> param = method.getParameters()[0].getType();
            if (!Event.class.isAssignableFrom(param) || method.getParameters().length != 1) {
                Kakara.LOGGER.warn("Unable to get EventType from " + method.getName());
                continue;
            }
            registeredEventHandler.add(new EventHandlerObject(method, (Class<? extends Event>) param, mod, handler));
        }
    }

    @Override
    public void callEvent(Event event) {
        List<EventHandlerObject> eventHandlers = registeredEventHandler.stream().filter(eventHandlerObject -> event.getClass() == eventHandlerObject.getEventType()).collect(Collectors.toList());

        for (EventHandlerObject e : eventHandlers) {
            if (event instanceof Cancellable) {
                if (((Cancellable) event).isCancelled()) break;
            }
            e.invokeEvent(event);
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
