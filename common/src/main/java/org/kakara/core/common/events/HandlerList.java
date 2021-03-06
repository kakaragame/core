package org.kakara.core.common.events;


import org.kakara.core.common.mod.Mod;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HandlerList {
    private final Class<? extends Event> eventClass;
    private List<RegisteredListener> listenerList = new CopyOnWriteArrayList<>();

    public HandlerList(Class<? extends Event> eventClass) {
        this.eventClass = eventClass;
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
