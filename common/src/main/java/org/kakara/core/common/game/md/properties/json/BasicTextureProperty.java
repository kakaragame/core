package org.kakara.core.common.game.md.properties.json;

import org.kakara.core.common.resources.Texture;

public class BasicTextureProperty extends JsonProperty {

    @Override
    public String propertyName() {
        return "texture";
    }

    public Texture getTexture() {
        return null;
    }
}
