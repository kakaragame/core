package org.kakara.core.game.player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.command.CommandSender;
import org.kakara.core.game.game.GameMode;
import org.kakara.core.game.gui.Inventory;
import org.kakara.core.game.gui.Menu;
import org.kakara.core.game.world.GameEntity;
import org.kakara.core.permission.Permissible;

public interface Player extends OfflinePlayer, GameEntity, CommandSender, Permissible {
    void sendToast(@NotNull Toast toast);

    void sendNotification(@NotNull String message);

    short getHealth();

    void setHealth(short health);

    short getHunger();

    void setHunger(short hunger);

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