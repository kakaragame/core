package org.kakara.core.events;

import org.kakara.core.mod.Mod;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventHandlerObject {
    private Method targetMethod;
    private Class<? extends Event> eventType;
    private Mod mod;
    private Object eventHandler;

    public EventHandlerObject(Method targetMethod, Class<? extends Event> eventType, Mod mod, Object eventHandler) {
        this.targetMethod = targetMethod;
        this.eventType = eventType;
        this.mod = mod;
        this.eventHandler = eventHandler;
    }

    public void invokeEvent(Event event) {
        try {
            targetMethod.invoke(eventHandler, event);
        } catch (IllegalAccessException | InvocationTargetException e) {
            mod.getLogger().error(mod.getName() + "Was unable to invoke " + event.getName(), e);
        }
    }

    public Method getTargetMethod() {
        return targetMethod;
    }

    public Class<? extends Event> getEventType() {
        return eventType;
    }

    public Mod getMod() {
        return mod;
    }

    public Object getEventHandler() {
        return eventHandler;
    }
}
