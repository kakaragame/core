package org.kakara.core.game;

import java.util.Set;

public interface GameMode {
    Set<String> getProperties();

    String getName();
}
