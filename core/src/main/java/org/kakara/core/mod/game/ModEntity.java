package org.kakara.core.mod.game;

import org.kakara.core.NameKey;
import org.kakara.core.annotations.Key;
import org.kakara.core.annotations.Model;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.game.Entity;
import org.kakara.core.mod.Mod;

import java.util.Objects;

public abstract class ModEntity implements Entity {
    protected final NameKey nameKey;
    protected final Mod mod;
    protected final String name;
    protected final int id;

    public ModEntity(Mod mod) {
        this.mod = mod;
        Name nameA = getClass().getAnnotation(Name.class);
        this.name = nameA == null ? getClass().getSimpleName() : nameA.value();
        Key keyA = getClass().getAnnotation(Key.class);
        this.nameKey = new NameKey(mod, keyA == null ? getClass().getSimpleName() : keyA.value());
        this.id = nameKey.hashCode();
    }


    @Override
    public String getTexture() {
        return getClass().getAnnotation(Texture.class).value();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public NameKey getNameKey() {
        return nameKey;
    }


    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getModel() {
        Model model = getClass().getAnnotation(Model.class);
        return model == null ? null : model.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModItem modItem = (ModItem) o;
        return modItem.getId() == getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), mod.getName());
    }
}
