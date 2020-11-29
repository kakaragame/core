package org.kakara.core.common.player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public interface OfflinePlayer {
    @NotNull
    UUID getUUID();

    @NotNull
    String getName();

    long getLastJoinTime();

    boolean isOnline();

    @Nullable
    Player toOnlinePlayer();

}
