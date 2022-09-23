package org.kakara.core.common.game.md.properties.json;

import com.google.gson.JsonObject;
import org.kakara.core.common.resources.Texture;

public class BasicTextureProperty extends JsonProperty {

    public BasicTextureProperty(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override
    public String propertyName() {
        return "TEXTURE";
    }

    public Texture getTexture() {
        return null;
    }
}
