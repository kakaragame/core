package org.kakara.core.mod.game;

import org.kakara.core.annotations.*;
import org.kakara.core.game.Item;
import org.kakara.core.mod.Mod;

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


}
