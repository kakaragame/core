package org.kakara.core.key;

import org.kakara.core.NameKey;
import org.kakara.core.key.events.KeyPressEvent;

public interface KeyBindHandler {

    NameKey getNameKey();

    String getName();


    void execute(KeyPressEvent event);
}
