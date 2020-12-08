package org.kakara.core.server.serializers.gson;

import com.google.gson.*;
import org.kakara.core.common.KValidate;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.world.World;
import org.kakara.core.server.ServerGameInstance;

import java.lang.reflect.Type;
import java.util.UUID;

public class WorldSerializer implements JsonSerializer<World>, JsonDeserializer<World> {
    @Override
    public World deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        KValidate.gameInstanceCheckServer();
        return ((ServerGameInstance) Kakara.getGameInstance()).getWorldManager().getWorldByUUID(UUID.fromString(jsonElement.getAsString()));
    }

    @Override
    public JsonElement serialize(World world, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(world.getUUID().toString());
    }
}
