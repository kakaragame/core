package org.kakara.core.client;

import org.kakara.core.world.World;

import java.util.List;

public interface Save {


    List<World> getWorlds();

    SaveSettings getSettings();
}

