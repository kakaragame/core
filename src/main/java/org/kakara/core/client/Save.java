package org.kakara.core.client;

import org.kakara.core.player.Player;
import org.kakara.core.world.World;

import java.util.List;
import java.util.UUID;

public interface Save {


    List<World> getWorlds();

    Player getPlayerLocation(UUID uuid);

    SaveSettings getSettings();
}

