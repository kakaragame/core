package org.kakara.core.common.events;

public interface Cancellable {
    boolean isCancelled();

    void setCancelled(boolean b);
}
