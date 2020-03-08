package org.kakara.core.events;

public interface Cancallable {
    boolean isCancelled();

    void setCancelled(boolean b);
}
