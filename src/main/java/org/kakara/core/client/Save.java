package org.kakara.core.client;

import org.kakara.core.world.World;

public interface Save {


    World[] getWorlds();

    SaveSettings getSettings();
}

