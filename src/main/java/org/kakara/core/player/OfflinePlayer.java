package org.kakara.core.player;

import org.kakara.core.command.CommandSender;

import java.util.UUID;

public interface OfflinePlayer extends CommandSender {
    UUID getUUID();

    String getName();

    long getLastJoinTime();

}
