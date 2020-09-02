package org.kakara.core.client;

import org.kakara.core.modinstance.ModInstance;

import java.util.Set;
import java.util.UUID;

public class SaveSettings {
    private String name;
    private Set<ModInstance> modInstances;
    private UUID defaultWorld;
    private Set<String> worlds;

    public SaveSettings(String name, Set<ModInstance> modInstances, UUID defaultWorld, Set<String> worlds) {
        this.name = name;
        this.modInstances = modInstances;
        this.defaultWorld = defaultWorld;
        this.worlds = worlds;
    }

    public UUID getDefaultWorld() {
        return defaultWorld;
    }

    public void setDefaultWorld(UUID defaultWorld) {
        this.defaultWorld = defaultWorld;
    }

    public void addModInstance(ModInstance modInstance) {
        this.modInstances.add(modInstance);
    }

    public void removeMod(ModInstance mod) {
        modInstances.remove(mod);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ModInstance> getModInstances() {
        return modInstances;
    }

    public void setModInstances(Set<ModInstance> modInstances) {
        this.modInstances = modInstances;
    }

    public Set<String> getWorlds() {
        return worlds;
    }

    public void setWorlds(Set<String> worlds) {
        this.worlds = worlds;
    }
}
