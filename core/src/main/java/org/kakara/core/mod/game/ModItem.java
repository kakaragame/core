package org.kakara.core.mod.game;

import org.kakara.core.NameKey;
import org.kakara.core.annotations.*;
import org.kakara.core.game.Item;
import org.kakara.core.mod.Mod;

import java.util.Objects;

public abstract class ModItem implements Item {
    protected final NameKey nameKey;
    protected final Mod mod;
    protected final String name;
    protected final int id;
    protected String texture;

    public ModItem(Mod mod) {
        this.mod = mod;
        Name nameA = getClass().getAnnotation(Name.class);
        this.name = nameA == null ? getClass().getSimpleName() : nameA.value();
        Key keyA = getClass().getAnnotation(Key.class);
        this.nameKey = new NameKey(mod, keyA == null ? getClass().getSimpleName() : keyA.value());
        this.id = nameKey.hashCode();
        texture = getClass().getAnnotation(Texture.class).value();
    }

    @Override
    public String getKey() {
        return nameKey.getKey();
    }

    @Override
    public String getTexture() {
        return texture;
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
    public final int getId() {
        return id;
    }

    @Override
    public String getModel() {
        Model model = getClass().getAnnotation(Model.class);
        return model == null ? null : model.value();
    }

    @Override
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
    public int hashCode() {
        return Objects.hash(getId(), getMod().getName());
    }
}
