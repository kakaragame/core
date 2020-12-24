package org.kakara.core.common.game.md;

import org.kakara.core.common.annotations.Model;
import org.kakara.core.common.resources.Texture;

//TODO think of better name.
public class ModelDataObject {
    private Texture texture;
    private Model model;

    public ModelDataObject(Texture texture, Model model) {
        this.texture = texture;
        this.model = model;
    }

    public Texture getTexture() {
        return texture;
    }

    public Model getModel() {
        return model;
    }
}
