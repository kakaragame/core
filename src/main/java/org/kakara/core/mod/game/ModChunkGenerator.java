package org.kakara.core.mod.game;

import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.mod.Mod;
import org.kakara.core.world.ChunkGenerator;

import java.net.IDN;
import java.util.Objects;

public abstract class ModChunkGenerator implements ChunkGenerator {
    private Mod mod;

    public ModChunkGenerator(Mod mod) {
        this.mod = mod;
    }

    @Override
    public String getName() {
        Name name = getClass().getAnnotation(Name.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }

    @Override
    public String getID() {
        Id name = getClass().getAnnotation(Id.class);
        return name == null ? getClass().getSimpleName() : name.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModChunkGenerator modChunkGenerator = (ModChunkGenerator) o;
        return Objects.equals(mod, modChunkGenerator.mod) && Objects.equals(getID(), modChunkGenerator.getID());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mod, getName(), getID());
    }
}
