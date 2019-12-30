package org.kakara.core.mod.game;

import org.kakara.core.annotations.Id;
import org.kakara.core.annotations.Name;
import org.kakara.core.annotations.Texture;
import org.kakara.core.annotations.Weight;
import org.kakara.core.game.Item;

public abstract class ModItem implements Item {

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
    public float getWeight() {
        Weight weight = getClass().getAnnotation(Weight.class);
        return weight == null ? 0.0f : weight.value();
    }
}
