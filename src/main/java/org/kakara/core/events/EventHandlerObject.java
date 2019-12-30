package org.kakara.core.events;

import org.kakara.core.mod.Mod;

import java.lang.reflect.Method;

public class EventHandlerObject {
    private Method targetMethod;
    private Class<? extends Event> eventType;
    private Mod mod;

    public void invokeEvent(Event event) {

    }
}
