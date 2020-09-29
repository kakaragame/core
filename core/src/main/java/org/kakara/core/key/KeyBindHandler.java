package org.kakara.core.key;

import org.kakara.core.ControllerKey;
import org.kakara.core.key.events.KeyPressEvent;

public interface KeyBindHandler {

    ControllerKey getNameKey();

    String getName();

    void execute(KeyPressEvent event);
}
