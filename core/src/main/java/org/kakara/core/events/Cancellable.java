package org.kakara.core.events;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled(boolean b);
}
