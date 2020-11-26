package org.kakara.core.game.events;

import org.kakara.core.mod.Mod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * An EventHandler as a Java object.
 */
public class EventHandlerObject {
    private final Method targetMethod;
    private final Class<? extends Event> eventType;
    private final Mod mod;
    private final Object eventHandler;

    /**
     * @param targetMethod the method to execute on the event call.
     * @param eventType    the type of Event.
     * @param mod          the Mod of the EventHandler.
     * @param eventHandler the raw EventHandler.
     */
    public EventHandlerObject(Method targetMethod, Class<? extends Event> eventType, Mod mod, Object eventHandler) {
        this.targetMethod = targetMethod;
        this.eventType = eventType;
        this.mod = mod;
        this.eventHandler = eventHandler;
    }

    /**
     * Calls the event.
     *
     * @param event the event to be used in calling.
     */
    public void invokeEvent(Event event) {
        try {
            targetMethod.invoke(eventHandler, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            mod.getLogger().error(mod.getName() + "Was unable to invoke " + event.getName(), e);
        }
    }

    /**
     * @return the method to execute on the event call.
     */
    public Method getTargetMethod() {
        return targetMethod;
    }

    /**
     * @return the type of Event.
     */
    public Class<? extends Event> getEventType() {
        return eventType;
    }

    /**
     * @return the Mod of the EventHandler.
     */
    public Mod getMod() {
        return mod;
    }

    /**
     * @return the raw EventHandler.
     */
    public Object getEventHandler() {
        return eventHandler;
    }
}
