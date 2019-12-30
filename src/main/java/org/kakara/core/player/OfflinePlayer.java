package org.kakara.core.player;

import java.util.UUID;

public interface OfflinePlayer {
    UUID getUUID();

    String getName();

    long getLastJoinTime();

}
