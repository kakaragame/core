package org.kakara.core.serializers.gson;

import com.google.gson.*;
import org.kakara.core.NameKey;
import org.kakara.core.game.ItemStack;

import java.lang.reflect.Type;

public class NameKeySerializer implements JsonSerializer<NameKey>, JsonDeserializer<NameKey> {

    @Override
    public NameKey deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return new NameKey(jsonElement.getAsString());
    }

    @Override
    public JsonElement serialize(NameKey nameKey, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(nameKey.toString());
    }
}
