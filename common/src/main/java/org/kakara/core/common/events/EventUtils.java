package org.kakara.core.common.events;


import org.kakara.core.common.Kakara;

import java.lang.reflect.InvocationTargetException;

public class EventUtils {
    public static HandlerList getHandlerList(Class<? extends Event> eventClass) {
        try {
            return (HandlerList) eventClass.getMethod("getHandlers").invoke(null);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            Kakara.LOGGER.error(String.format("Unable to get HandlerList from %s", eventClass.getName()), e);
            return null;
        }
    }
}
