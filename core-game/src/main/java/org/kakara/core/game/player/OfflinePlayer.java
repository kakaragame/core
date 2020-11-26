package org.kakara.core.game.player;

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

    void ban(@Nullable String reason);

    void ban(long duration, @NotNull TimeUnit timeUnit, @Nullable String reason);
}
