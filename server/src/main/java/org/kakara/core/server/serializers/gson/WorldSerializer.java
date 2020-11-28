package org.kakara.core.server.serializers.gson;

import com.google.gson.*;
import org.kakara.core.common.world.World;

import java.lang.reflect.Type;

public class WorldSerializer implements JsonSerializer<World>, JsonDeserializer<World> {
    @Override
    public World deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;//Kakara.getWorldManager().getWorldByUUID(UUID.fromString(jsonElement.getAsString()));
    }

    @Override
    public JsonElement serialize(World world, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(world.getUUID().toString());
    }
}
