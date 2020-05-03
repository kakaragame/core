package org.kakara.core.key.events;

import org.kakara.core.key.KeyBind;

public class KeyPressEvent {
    private KeyBind keyBind;

    public KeyPressEvent(KeyBind keyBind) {
        this.keyBind = keyBind;
    }
}
