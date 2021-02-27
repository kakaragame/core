package org.kakara.core.common.player;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.Serverable;
import org.kakara.core.common.command.CommandSender;
import org.kakara.core.common.game.GameMode;
import org.kakara.core.common.gui.Inventory;
import org.kakara.core.common.permission.Permissible;
import org.kakara.core.common.player.meter.PlayerMeterController;
import org.kakara.core.common.world.GameEntity;


public interface Player extends OfflinePlayer, GameEntity, CommandSender, Permissible, Serverable {

    @NotNull
    String getDisplayName();

    @NotNull
    Inventory getInventory();

    GameMode getGameMode();

    /**
     * The players levels and meters.
     *
     * @return the meter controller.
     */
    PlayerMeterController getMeterController();

}