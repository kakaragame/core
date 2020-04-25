package org.kakara.core.player;

import org.kakara.core.command.CommandSender;
import org.kakara.core.permission.Permissible;
import org.kakara.core.world.GameEntity;


public interface Player extends OfflinePlayer, GameEntity, CommandSender, Permissible {


}
