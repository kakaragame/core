package org.kakara.core.mod.game;

import org.kakara.core.NameKey;
import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Model;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.game.Entity;
import org.kakara.core.game.entity.EntitySpawningPattern;
import org.kakara.core.game.entity.PathFinder;
import org.kakara.core.mod.Mod;

import java.util.Objects;

public abstract class ModEntity implements Entity {
    private final NameKey nameKey;
    private Mod mod;
    private String name;
    private int id;

    public ModEntity(Mod mod) {
        this.mod = mod;
        Name name = getClass().getAnnotation(Name.class);
        this.name = name == null ? getClass().getSimpleName() : name.value();
        Id id = getClass().getAnnotation(Id.class);
        this.nameKey = new NameKey(mod, id == null ? getClass().getSimpleName() : id.value());
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
    public final int getId() {
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
