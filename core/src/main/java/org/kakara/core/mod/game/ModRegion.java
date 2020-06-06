package org.kakara.core.mod.game;

import org.kakara.core.NameKey;
import org.kakara.core.annotations.Key;
import org.kakara.core.annotations.Name;
import org.kakara.core.mod.Mod;
import org.kakara.core.world.region.Region;

import java.util.Objects;

public abstract class ModRegion implements Region {

    protected final Mod mod;
    protected final NameKey nameKey;
    protected final int id;
    protected final String name;

    public ModRegion(Mod mod) {
        this.mod = mod;
        Name nameA = getClass().getAnnotation(Name.class);
        this.name = nameA == null ? getClass().getSimpleName() : nameA.value();
        Key keyA = getClass().getAnnotation(Key.class);
        this.nameKey = new NameKey(mod, keyA == null ? getClass().getSimpleName() : keyA.value());
        this.id = nameKey.hashCode();
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
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
        return Objects.equals(mod, modRegion.mod) && Objects.equals(getName(), modRegion.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mod, getName());
    }
}
