package org.kakara.core.common.mod.game;



import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.annotations.Key;
import org.kakara.core.common.annotations.Name;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.world.WorldGenerator;

import java.util.Objects;

public abstract class ModWorldGenerator implements WorldGenerator {
    protected final GameMod mod;
    protected final ControllerKey nameKey;
    protected final int id;
    protected final String name;
    protected final String key;

    public ModWorldGenerator(GameMod mod) {
        this.mod = mod;
        Name nameA = getClass().getAnnotation(Name.class);
        this.name = nameA == null ? getClass().getSimpleName() : nameA.value();
        Key keyA = getClass().getAnnotation(Key.class);
        key = keyA == null ? getClass().getSimpleName() : keyA.value();
        this.nameKey = new ControllerKey(mod, key);

        this.id = nameKey.hashCode();
    }


    @Override
    public ControllerKey getControllerKey() {
        return nameKey;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModWorldGenerator modChunkGenerator = (ModWorldGenerator) o;
        return Objects.equals(mod, modChunkGenerator.mod) && Objects.equals(getName(), modChunkGenerator.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(mod, getName(), getKey());
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
    public String getKey() {
        return key;
    }
}
