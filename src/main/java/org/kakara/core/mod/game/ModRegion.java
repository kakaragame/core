package org.kakara.core.mod.game;

import org.kakara.core.NameKey;
import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.mod.Mod;
import org.kakara.core.world.region.Region;

import java.util.Objects;

public abstract class ModRegion implements Region {

    private Mod mod;
    private NameKey nameKey;

    public ModRegion(Mod mod) {
        this.mod = mod;
        this.nameKey = new NameKey(mod, getID());
    }

    @Override
    public String getName() {
        Name name = getClass().getAnnotation(Name.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }

    public String getID() {
        Id name = getClass().getAnnotation(Id.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }

    @Override
    public NameKey getNameKey() {
        return nameKey;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModRegion modRegion = (ModRegion) o;
        return Objects.equals(mod, modRegion.mod) && Objects.equals(getID(), modRegion.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mod, getName(), getID());
    }
}
