package org.kakara.core.common.game;

import org.kakara.core.common.GameObject;
import org.kakara.core.common.events.RegisteredListener;

import java.util.HashSet;
import java.util.Set;

public abstract class SimpleGameObject implements GameObject {
    public Set<RegisteredListener> listeners = new HashSet<>();

    public SimpleGameObject() {
        //TODO load listeners

    }

    @Override
    public Set<RegisteredListener> getRegisteredListeners() {
        return listeners;
    }
}
