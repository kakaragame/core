package org.kakara.core.common.events;

import org.kakara.core.common.mod.Mod;

import java.lang.reflect.Method;

public class RegisteredListener {
    private final Listener listener;
    private final Mod mod;
    private final Class<? extends Event> eventClass;
    private Method handlerMethod;

    public RegisteredListener(Listener listener, Mod mod, Method handlerMethod, Class<? extends Event> eventClass) {
        this.listener = listener;
        this.mod = mod;
        this.handlerMethod = handlerMethod;
        this.eventClass = eventClass;
    }

    public RegisteredListener(Listener listener, Mod mod, Class<? extends Event> eventClass) {
        this.listener = listener;
        this.mod = mod;
        this.eventClass = eventClass;
        for (Method declaredMethod : listener.getClass().getDeclaredMethods()) {
            if (declaredMethod.getParameterTypes().length == 1 && declaredMethod.getParameterTypes()[0] == eventClass) {
                handlerMethod = declaredMethod;
            }
        }
    }

    public EventExecutor call() {
        return new EventExecutor(handlerMethod, listener);
    }

    public Listener getListener() {
        return listener;
    }

    public Mod getMod() {
        return mod;
    }

    public Method getHandlerMethod() {
        return handlerMethod;
    }
}
