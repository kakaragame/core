package org.kakara.core.common.events;


import org.kakara.core.common.Kakara;

import java.lang.reflect.InvocationTargetException;

public class EventExecutor {
    private final RegisteredListener registeredListener;

    public EventExecutor(RegisteredListener registeredListener) {
        this.registeredListener = registeredListener;
    }

    public void execute(Event event) throws EventException {
        if (registeredListener.getEnvType() != null) {
            if (Kakara.getEnvironmentInstance().getType() != registeredListener.getEnvType()) {
                return;
            }
        }
        try {
            registeredListener.getHandlerMethod().invoke(registeredListener.getListener(), event);
        } catch (IllegalAccessException e) {
            throw new EventException("Unable to access event handler", e);
        } catch (InvocationTargetException e) {
            throw new EventException("Unable to invoke Method ", e);
        }
    }


}
