package org.kakara.core.mod.game;

import org.kakara.core.ControllerKey;
import org.kakara.core.annotations.Key;
import org.kakara.core.annotations.Name;
import org.kakara.core.charm.Charm;
import org.kakara.core.mod.Mod;

import java.util.Objects;

public abstract class ModCharm implements Charm {
    private final ControllerKey nameKey;
    private final Mod mod;
    private final String name;
    private final int id;

    public ModCharm(Mod mod) {
        this.mod = mod;
        Name nameA = getClass().getAnnotation(Name.class);
        this.name = nameA == null ? getClass().getSimpleName() : nameA.value();
        Key keyA = getClass().getAnnotation(Key.class);
        this.nameKey = new ControllerKey(mod, keyA == null ? getClass().getSimpleName() : keyA.value());
        this.id = nameKey.hashCode();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public ControllerKey getControllerKey() {
        return nameKey;
    }

    @Override
    public final int getId() {
        return id;
    }

    public Mod getMod() {
        return mod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModItem modItem = (ModItem) o;
        return modItem.getId() == getId();
    }


    @Override
    public String getKey() {
        return nameKey.getKey();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), mod.getName());
    }
}
