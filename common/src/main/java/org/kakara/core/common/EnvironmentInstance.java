package org.kakara.core.common;

import org.kakara.core.common.mod.ModManager;
import org.kakara.core.common.resources.ResourceManager;
import org.kakara.core.common.service.ServiceManager;
import org.kakara.core.common.settings.SettingManager;

import java.io.File;

public interface EnvironmentInstance extends EnvTypeable {
    ModManager getModManager();

    File getWorkingDirectory();

    /**
     * EnvType for Environment.
     *
     * @return environment
     */
    EnvType getType();

    ResourceManager getResourceManager();

    /**
     * The settings stored in here are for the entire Environment
     *
     * @return the environment's setting manager
     */
    SettingManager getEnvironmentSettingsManager();

    /**
     * Creates a ControllerKey for the system
     *
     * @param key the key
     * @return A ControllerKey
     */
    ControllerKey createSystemKey(String key);

    ServiceManager getServiceManager();

}

