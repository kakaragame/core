package org.kakara.core.client;

import org.kakara.core.modinstance.ModInstance;

import java.util.List;

public class SaveSettings {
    private String name;
    private List<ModInstance> modInstances;

    public SaveSettings(String name, List<ModInstance> modInstances) {
        this.name = name;
        this.modInstances = modInstances;
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

    public List<ModInstance> getModInstances() {
        return modInstances;
    }

    public void setModInstances(List<ModInstance> modInstances) {
        this.modInstances = modInstances;
    }
}
