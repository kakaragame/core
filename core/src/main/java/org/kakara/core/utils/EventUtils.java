package org.kakara.core.utils;

import org.kakara.core.events.Event;
import org.kakara.core.events.FunctionalEvent;

public class EventUtils {
    /**
     * Executes a Functional Event if FunctionalEvent is not null
     *
     * @param functionalEvent the FunctionalEvent
     * @param t               the Event Object
     * @param <T>             the Event Type
     * @see FunctionalEvent
     */
    public <T extends Event> void executeIfNotNull(FunctionalEvent<T> functionalEvent, T t) {
        if (functionalEvent != null) functionalEvent.execute(t);
    }
}
