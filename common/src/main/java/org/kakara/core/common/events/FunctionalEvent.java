package org.kakara.core.common.events;

@FunctionalInterface
public interface FunctionalEvent<T extends Event> {
    void execute(T t);
}
