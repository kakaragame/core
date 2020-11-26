package org.kakara.core.game.game;

import java.util.Set;

public interface GameMode {
    Set<String> getProperties();

    String getName();
}
