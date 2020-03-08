package org.kakara.core.events;

public interface Event {
    default String getName() {
        return getClass().getSimpleName();
    }

}
