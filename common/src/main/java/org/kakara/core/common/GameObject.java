package org.kakara.core.common;

import org.kakara.core.common.events.Listener;
import org.kakara.core.common.events.RegisteredListener;

import java.util.Set;

public interface GameObject extends Listener {
    Set<RegisteredListener> getRegisteredListeners();

}
