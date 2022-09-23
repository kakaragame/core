package org.kakara.core.common.game.md.properties.json;

import com.google.gson.JsonObject;

public class ModelProperty extends JsonProperty {
    public ModelProperty(JsonObject jsonObject) {
        super(jsonObject);
    }

    @Override
    public String propertyName() {
        return "MODEL";
    }

    public String getModel() {
        return "";
    }
}
