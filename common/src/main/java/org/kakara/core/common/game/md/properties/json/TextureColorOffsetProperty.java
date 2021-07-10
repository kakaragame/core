package org.kakara.core.common.game.md.properties.json;

import com.google.gson.JsonObject;

public class TextureColorOffsetProperty extends JsonProperty {
    public TextureColorOffsetProperty(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override
    public String propertyName() {
        return "COLOR_OFFSET";
    }
}
