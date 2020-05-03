package org.kakara.core.key;

import java.util.Map;

public interface KeyBindManager {

    Map<KeyBind, KeyBindHandler> keysBound();

    void registerKeyBound(KeyBind defaultKeyBind, KeyBindHandler handler);
}
