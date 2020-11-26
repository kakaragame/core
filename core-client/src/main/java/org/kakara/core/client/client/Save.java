package org.kakara.core.client.client;

import org.kakara.core.exceptions.WorldLoadException;
import org.kakara.core.game.world.World;

import java.io.File;
import java.util.List;
import java.util.Set;

/**
 * This is a save of worlds in Kakara.
 */
public interface Save {
    void prepareWorlds() throws WorldLoadException;

    /**
     * @return all the worlds present in the save.
     */
    Set<World> getWorlds();

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

