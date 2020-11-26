package org.kakara.core.common.serializers.gson;

import com.google.gson.*;
import org.kakara.core.common.Kakara;
import org.kakara.core.game.world.World;

import java.lang.reflect.Type;
import java.util.UUID;

public class WorldSerializer implements JsonSerializer<World>, JsonDeserializer<World> {
    @Override
    public World deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Kakara.getWorldManager().getWorldByUUID(UUID.fromString(jsonElement.getAsString()));
    }

    @Override
    public JsonElement serialize(World world, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(world.getUUID().toString());
    }
}
