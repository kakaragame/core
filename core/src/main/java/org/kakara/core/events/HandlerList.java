package org.kakara.core.events;

import org.checkerframework.checker.units.qual.A;
import org.kakara.core.events.player.Listener;
import org.kakara.core.mod.Mod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HandlerList {
    private List<RegisteredListener> listenerList = new CopyOnWriteArrayList<>();
    private final Class<? extends Event> eventClass;

    public HandlerList(Class<? extends Event> eventClass) {
        this.eventClass = eventClass;
    }

    public void addHandler(Mod mod, Listener listener) {
        listenerList.add(new RegisteredListener(listener, mod, eventClass));
    }

    public void addHandler(Mod mod, Listener listener, Method method) {
        listenerList.add(new RegisteredListener(listener, mod, method, eventClass));
    }

    public void removeAllHandlersByMod(Mod mod) {
        listenerList.removeIf(registeredListener -> registeredListener.getMod().equals(mod));
    }

    public void removeAllHandlers(Mod mod) {
        listenerList = new ArrayList<>();
    }

    public List<RegisteredListener> getListenerList() {
        return new ArrayList<>(listenerList);
    }

    public Class<? extends Event> getEventClass() {
        return eventClass;
    }
}
