package org.kakara.core.key;

import java.util.Map;

public interface KeyBoundManager {

    Map<KeyBound, KeyBoundHandler> keysBound();

    void registerKeyBound(KeyBound defaultKeyBound, KeyBoundHandler handler);
}
