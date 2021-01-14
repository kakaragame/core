package org.kakara.core.common.game;

import me.kingtux.simpleannotation.MethodFinder;
import org.kakara.core.common.GameObject;
import org.kakara.core.common.events.Event;
import org.kakara.core.common.events.RegisteredListener;
import org.kakara.core.common.events.annotations.EventHandler;
import org.kakara.core.common.mod.Mod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class SimpleGameObject implements GameObject {
    protected final Map<Class<? extends Event>, RegisteredListener> listeners = new HashMap<>();

    public SimpleGameObject() {
        Method[] methods = MethodFinder.getAllMethodsWithAnnotation(getClass(), EventHandler.class, false);
        for (Method method : methods) {
            if (method.getParameterTypes().length == 1) {
                Class<? extends Event> event = (Class<? extends Event>) method.getParameterTypes()[0];
                listeners.put(event, new RegisteredListener(this, getMod(), method, event));
            }
        }
    }


    public abstract Mod getMod();

    @Override
    public Map<Class<? extends Event>, RegisteredListener> getRegisteredListeners() {
        return listeners;
    }
}
