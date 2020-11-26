package org.kakara.core.common.serializers.gson;

import com.google.gson.*;
import org.kakara.core.common.Kakara;
import org.kakara.core.player.OfflinePlayer;

import java.lang.reflect.Type;
import java.util.UUID;

public class OfflinePlayerSerializer implements JsonSerializer<OfflinePlayer>, JsonDeserializer<OfflinePlayer> {
    @Override
    public OfflinePlayer deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return Kakara.getOfflinePlayer(UUID.fromString(jsonElement.getAsString()));
    }

    @Override
    public JsonElement serialize(OfflinePlayer offlinePlayer, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(offlinePlayer.getUUID().toString());
    }
}
