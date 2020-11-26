package org.kakara.core.game.events;

@FunctionalInterface
public interface FunctionalEvent<T extends Event> {
    void execute(T t);
}
