package org.kakara.core.common;

import org.kakara.core.common.mod.ModManager;

import java.io.File;

public interface EnvironmentInstance {
    ModManager getModManager();

    File getWorkingDirectory();

    EnvType getType();

}

