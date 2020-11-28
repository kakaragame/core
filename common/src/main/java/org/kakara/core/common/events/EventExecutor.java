package org.kakara.core.common.events;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EventExecutor {
    private final Method method;
    private final Listener listener;

    public EventExecutor(Method method, Listener listener) {
        this.method = method;
        this.listener = listener;
    }

    public void execute(Event event) throws EventException {
        try {
            method.invoke(listener, event);
        } catch (IllegalAccessException e) {
            throw new EventException("Unable to access event handler", e);
        } catch (InvocationTargetException e) {
            throw new EventException("Unable to invoke Method ", e);
        }
    }


}
