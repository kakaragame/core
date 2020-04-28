package org.kakara.core.modinstance;

import org.kakara.core.mod.ModSetting;

import java.io.File;

public class ModInstanceBuilder {
    private String name;
    private String modServer;
    private String modVersion;
    private ModSetting modSettings;
    private ModInstanceType type;
    private File modFile;

    public ModInstanceBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ModInstanceBuilder setModServer(String modServer) {
        this.modServer = modServer;
        return this;
    }

    public ModInstanceBuilder setModVersion(String modVersion) {
        this.modVersion = modVersion;
        return this;
    }

    public ModInstanceBuilder setModSettings(ModSetting modSettings) {
        this.modSettings = modSettings;
        return this;
    }

    public ModInstanceBuilder setType(ModInstanceType type) {
        this.type = type;
        return this;
    }

    public ModInstanceBuilder setModFile(File modFile) {
        this.modFile = modFile;
        return this;
    }

    public ModInstance createModInstance() {
        return new ModInstance(name, modServer, modVersion, modSettings, type, modFile);
    }
}