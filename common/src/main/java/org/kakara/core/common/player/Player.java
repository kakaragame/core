package org.kakara.core.common.player;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.common.Serverable;
import org.kakara.core.common.command.CommandSender;
import org.kakara.core.common.game.GameMode;
import org.kakara.core.common.gui.Inventory;
import org.kakara.core.common.permission.Permissible;
import org.kakara.core.common.world.GameEntity;


public interface Player extends OfflinePlayer, GameEntity, CommandSender, Permissible, Serverable {

    short getHealth();

    short getHunger();

    @NotNull
    String getDisplayName();

    @NotNull
    Inventory getInventory();

    GameMode getGameMode();

}