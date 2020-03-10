package org.kakara.core.mod.game;

import org.kakara.core.annotations.*;
import org.kakara.core.game.Item;
import org.kakara.core.mod.Mod;

import java.util.Objects;

public abstract class ModItem implements Item {
    private Mod mod;

    public ModItem(Mod mod) {
        this.mod = mod;
    }

    @Override
    public String getName() {
        return getClass().getAnnotation(Name.class).value();
    }

    @Override
    public String getTexture() {
        return getClass().getAnnotation(Texture.class).value();
    }

    @Override
    public String getId() {
        return getClass().getAnnotation(Id.class).value();
    }

    @Override
    public String getModel() {
        Model model = getClass().getAnnotation(Model.class);
        return model == null ? null : model.value();
    }

    @Override
    public float getWeight() {
        Weight weight = getClass().getAnnotation(Weight.class);
        return weight == null ? 0.0f : weight.value();
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
        return Objects.equals(mod.getName(), modItem.mod.getName()) && Objects.equals(getId(), modItem.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMod().getName());
    }
}
