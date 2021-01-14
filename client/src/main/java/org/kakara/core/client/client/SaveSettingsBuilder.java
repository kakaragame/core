package org.kakara.core.client.client;


import org.kakara.core.common.modinstance.ModInstance;

import java.util.Set;
import java.util.UUID;

public class SaveSettingsBuilder {
    private String name;
    private Set<ModInstance> modInstances;
    private UUID defaultWorld;
    private Set<String> worlds;

    public SaveSettingsBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SaveSettingsBuilder setModInstances(Set<ModInstance> modInstances) {
        this.modInstances = modInstances;
        return this;
    }

    public SaveSettingsBuilder setDefaultWorld(UUID defaultWorld) {
        this.defaultWorld = defaultWorld;
        return this;
    }

    public SaveSettingsBuilder setWorlds(Set<String> worlds) {
        this.worlds = worlds;
        return this;
    }

    public SaveSettings createSaveSettings() {
        return new SaveSettings(name, modInstances, defaultWorld, worlds);
    }
}