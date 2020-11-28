package org.kakara.core.common.game;

import java.util.Set;

public interface GameMode {
    Set<String> getProperties();

    String getName();
}
