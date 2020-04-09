package org.kakara.core.mod.game;

import org.kakara.core.NameKey;
import org.kakara.core.annotations.*;
import org.kakara.core.game.Item;
import org.kakara.core.mod.Mod;

import java.util.Objects;

public abstract class ModItem implements Item {
    private final NameKey nameKey;
    private Mod mod;
    private String name;
    private String id;

    public ModItem(Mod mod) {
        this.mod = mod;
        Id id = getClass().getAnnotation(Id.class);
        this.id = id == null ? getClass().getSimpleName() : id.value();
        Name name = getClass().getAnnotation(Name.class);
        this.name = name == null ? getClass().getSimpleName() : name.value();
        this.nameKey = new NameKey(mod, getId());
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
    public String getId() {
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
        return nameKey.equals(modItem.nameKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMod().getName());
    }
}
