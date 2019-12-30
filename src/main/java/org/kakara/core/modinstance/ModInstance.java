package org.kakara.core.modinstance;


import org.kakara.core.mod.ModSetting;

public class ModInstance {
    private String name;
    private String modServer;
    private String modVersion;
    private ModSetting modSettings;
    private ModInstanceType type;

    public ModInstance(String name, String modServer, String modVersion, ModSetting modSettings, ModInstanceType type) {
        this.name = name;
        this.modServer = modServer;
        this.modVersion = modVersion;
        this.modSettings = modSettings;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModServer() {
        return modServer;
    }

    public void setModServer(String modServer) {
        this.modServer = modServer;
    }

    public String getModVersion() {
        return modVersion;
    }

    public void setModVersion(String modVersion) {
        this.modVersion = modVersion;
    }

    public ModSetting getModSettings() {
        return modSettings;
    }

    public void setModSettings(ModSetting modSettings) {
        this.modSettings = modSettings;
    }

    public ModInstanceType getType() {
        return type;
    }

    public void setType(ModInstanceType type) {
        this.type = type;
    }
}
