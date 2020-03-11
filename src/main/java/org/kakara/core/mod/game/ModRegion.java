package org.kakara.core.mod.game;

import org.kakara.core.annotations.Name;
import org.kakara.core.mod.Mod;
import org.kakara.core.world.region.Region;

import java.util.Objects;

public abstract class ModRegion implements Region {

    private Mod mod;

    public ModRegion(Mod mod) {
        this.mod = mod;
    }

    @Override
    public String getName() {
        Name name = getClass().getAnnotation(Name.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModRegion modRegion = (ModRegion) o;
        return Objects.equals(mod, modRegion.mod) && Objects.equals(getName(), modRegion.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mod, getName());
    }
}
