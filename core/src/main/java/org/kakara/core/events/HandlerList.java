package org.kakara.core.events;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HandlerList {
    private List<RegisteredListener> listenerList = new CopyOnWriteArrayList<>();



}
