package org.kakara.core.events;

@FunctionalInterface
public interface FunctionalEvent<T extends Event> {
    void execute(T t);
}
