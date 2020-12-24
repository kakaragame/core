package org.kakara.core.common.game.md;

import org.kakara.core.common.game.md.properties.json.BasicTextureProperty;
import org.kakara.core.common.game.md.properties.json.ModelProperty;
import org.kakara.core.common.resources.Texture;

//TODO think of better name.
public class ModelDataObject {
    private final ModelDataProperties properties;
    private final int id;

    public ModelDataObject(ModelDataProperties properties, int id) {
        this.properties = properties;
        this.id = id;
    }

    public Texture getTexture() {
        return ((BasicTextureProperty) properties.getProperty("TEXTURE")).getTexture();
    }

    public String getModel() {
        return ((ModelProperty) properties.getProperty("MODEL")).getModel();
    }

    public int getId() {
        return id;
    }
}
