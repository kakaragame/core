package org.kakara.core.server.serializers.gson;

import com.google.gson.*;
import org.kakara.core.common.gui.Inventory;

import java.lang.reflect.Type;

public class InventorySerializer implements JsonSerializer<Inventory>, JsonDeserializer<Inventory> {
    @Override
    public Inventory deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }

    @Override
    public JsonElement serialize(Inventory inventory, Type type, JsonSerializationContext jsonSerializationContext) {


        return null;
    }
}
