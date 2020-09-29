package org.kakara.core.serializers.gson;

import com.google.gson.*;
import org.kakara.core.ControllerKey;

import java.lang.reflect.Type;

public class NameKeySerializer implements JsonSerializer<ControllerKey>, JsonDeserializer<ControllerKey> {

    @Override
    public ControllerKey deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new ControllerKey(jsonElement.getAsString());
    }

    @Override
    public JsonElement serialize(ControllerKey nameKey, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(nameKey.toString());
    }
}
