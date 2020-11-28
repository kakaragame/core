package org.kakara.core.common.events;

import org.kakara.core.common.EnvType;
import org.kakara.core.common.annotations.Environment;
import org.kakara.core.common.mod.Mod;

import java.lang.reflect.Method;

public class RegisteredListener {
    private final Listener listener;
    private final Mod mod;
    private final Class<? extends Event> eventClass;
    private final Method handlerMethod;
    private final EnvType envType;

    public RegisteredListener(Listener listener, Mod mod, Method handlerMethod, Class<? extends Event> eventClass) {
        this.listener = listener;
        this.mod = mod;
        this.handlerMethod = handlerMethod;
        this.eventClass = eventClass;
        if (handlerMethod.isAnnotationPresent(Environment.class))
            envType = handlerMethod.getAnnotation(Environment.class).value();
        else envType = null;
    }

    public EventExecutor call() {
        return new EventExecutor(this);
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

    public EnvType getEnvType() {
        return envType;
    }

    public Class<? extends Event> getEventClass() {
        return eventClass;
    }
}
