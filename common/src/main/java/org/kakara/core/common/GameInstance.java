package org.kakara.core.common;

import org.kakara.core.common.command.CommandManager;
import org.kakara.core.common.events.EventManager;
import org.kakara.core.common.game.GameSettings;
import org.kakara.core.common.game.ItemManager;
import org.kakara.core.common.mod.ModManager;
import org.kakara.core.common.resources.ResourceManager;

import java.io.File;

public interface GameInstance extends Serverable {
    default EnvironmentInstance getEnvironment() {
        return Kakara.getEnvironmentInstance();
    }

    default EnvType getType() {
        return getEnvironment().getType();
    }

    File getWorkingDirectory();

    ResourceManager getResourceManager();

    GameSettings getGameSettings();

    ItemManager getItemManager();

    CommandManager getCommandManager();

    EventManager getEventManager();

    ModManager getModManager();
}
