package org.kakara.core.client;

import org.kakara.core.world.World;

import java.io.File;
import java.util.List;

/**
 * This is a save of worlds in Kakara.
 */
public interface Save {
    void prepareWorlds();
    /**
     * @return all the worlds present in the save.
     */
    List<World> getWorlds();

    /**
     * @return the default world where players are first spawned into.
     */
    World getDefaultWorld();

    /**
     * @return the SaveSettings for this specific save.
     */
    SaveSettings getSettings();

    File getSaveFolder();

    List<File> getModsToLoad();

}
