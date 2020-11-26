package org.kakara.core.client.client;

import org.kakara.core.exceptions.SaveLoadException;

import java.io.File;

public interface SaveSettingsParser {

    SaveSettings fromFile(File file) throws SaveLoadException;

    void toFile(File file, SaveSettings saveSettings) throws SaveLoadException;
}
