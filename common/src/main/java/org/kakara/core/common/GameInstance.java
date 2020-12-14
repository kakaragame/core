package org.kakara.core.common;

import org.kakara.core.common.command.CommandManager;
import org.kakara.core.common.events.EventManager;
import org.kakara.core.common.game.GameSettings;
import org.kakara.core.common.game.ItemManager;
import org.kakara.core.common.gui.container.ContainerUtils;
import org.kakara.core.common.mod.ModManager;
import org.kakara.core.common.resources.ResourceManager;
import org.kakara.core.common.service.ServiceManager;
import org.kakara.core.common.settings.SettingManager;

import java.io.File;

public interface GameInstance extends Serverable, EnvTypeable {
    default EnvironmentInstance getEnvironment() {
        return Kakara.getEnvironmentInstance();
    }

    /**
     * EnvType for GameInstance.
     * <p>
     * If this is a Client on a IntegratedServer it will return server.
     * If this is a Client on a external server it will return Client.
     * Server is always server.
     *
     * @return EnvType
     */
    EnvType getType();

    /**
     * The settings stored in here are per game.
     *
     * @return the games setting manager
     */
    SettingManager getGameSettingsManager();

    File getWorkingDirectory();

    ResourceManager getResourceManager();

    GameSettings getGameSettings();

    ItemManager getItemManager();

    CommandManager getCommandManager();

    EventManager getEventManager();

    ModManager getModManager();

    ContainerUtils getContainerUtils();

    ServiceManager getServiceManager();
}
