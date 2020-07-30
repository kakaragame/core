package org.kakara.core.player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.command.CommandSender;
import org.kakara.core.game.GameMode;
import org.kakara.core.gui.Inventory;
import org.kakara.core.gui.Menu;
import org.kakara.core.mod.game.GameMod;
import org.kakara.core.permission.Permissible;
import org.kakara.core.world.GameEntity;

import java.util.concurrent.TimeUnit;

public interface Player extends OfflinePlayer, GameEntity, CommandSender, Permissible {
    void sendToast(@NotNull Toast toast);

    void sendNotification(@NotNull String message);

    void setHealth(short health);

    short getHealth();



    void setHunger(short hunger);

    short getHunger();

    @NotNull
    String getDisplayName();

    void setDisplayName(@NotNull String displayName);

    void kick(@Nullable String reason);

    @NotNull
    Inventory getInventory();

    void openMenu(@NotNull Menu menu);

    void sendMessage(@NotNull String message);

    GameMode getGameMode();

    void setGameMode(GameMode gameMode);
}