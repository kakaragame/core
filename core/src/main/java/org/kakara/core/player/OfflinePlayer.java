package org.kakara.core.player;

import org.kakara.core.command.CommandSender;

import java.util.UUID;

public interface OfflinePlayer {
    UUID getUUID();

    String getName();

    long getLastJoinTime();

    boolean isOnline();

    Player toOnlinePlayer();

}
