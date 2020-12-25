package org.kakara.core.common.game.md.properties.json;

import com.google.gson.JsonObject;
import org.kakara.core.common.game.md.properties.ModelDataProperty;

public abstract class JsonProperty implements ModelDataProperty {
    private JsonObject jsonObject;

    public JsonProperty(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }


}
