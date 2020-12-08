package org.kakara.core.common;

import org.kakara.core.common.mod.ModManager;
import org.kakara.core.common.resources.ResourceManager;

import java.io.File;

public interface EnvironmentInstance {
    ModManager getModManager();

    File getWorkingDirectory();

    /**
     * EnvType for Environment.
     *
     * @return environment
     */
    EnvType getType();

    ResourceManager getResourceManager();

}

