package org.kakara.core.events;

import org.kakara.core.events.player.Listener;
import org.kakara.core.mod.Mod;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HandlerList {
    private List<RegisteredListener> listenerList = new CopyOnWriteArrayList<>();

    public void addHandler(Mod mod, Listener listener) {

    }

}
