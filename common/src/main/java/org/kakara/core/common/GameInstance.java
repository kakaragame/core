package org.kakara.core.common;

import org.kakara.core.common.command.CommandManager;
import org.kakara.core.common.events.EventManager;
import org.kakara.core.common.game.GameSettings;
import org.kakara.core.common.game.ItemRegistry;
import org.kakara.core.common.gui.container.ContainerUtils;
import org.kakara.core.common.mod.ModManager;
import org.kakara.core.common.resources.ResourceManager;
import org.kakara.core.common.service.ServiceManager;
import org.kakara.core.common.settings.SettingRegistry;

import java.io.File;

/**
 * Unlike a EnvironmentInstance game instances are recreated everytime you join a new save or server.
 * This is where you will access all controls for the game.
 */
public interface GameInstance extends Serverable, EnvTypeable {
    /**
     * Get the EnvironmentInstance
     *
     * @return the EnvironmentInstance
     */
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
    SettingRegistry getGameSettingRegistry();

    /**
     * The GameInstance working directory.
     *
     * @return the working directory
     */
    File getWorkingDirectory();

    /**
     * GameInstance ResourceManager.
     *
     * @return game instance ResourceManager
     */
    ResourceManager getResourceManager();

    GameSettings getGameSettings();

    ItemRegistry getItemRegistry();

    CommandManager getCommandManager();

    EventManager getEventManager();

    ModManager getModManager();

    ContainerUtils getContainerUtils();

    ServiceManager getServiceManager();
}
