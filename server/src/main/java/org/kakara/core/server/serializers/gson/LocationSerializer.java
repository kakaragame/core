package org.kakara.core.server.serializers.gson;

import com.google.gson.*;
import org.kakara.core.common.world.Location;
import org.kakara.core.common.world.World;

import java.lang.reflect.Type;

public class LocationSerializer implements JsonSerializer<Location>, JsonDeserializer<Location> {
    @Override
    public Location deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject o = jsonElement.getAsJsonObject();
        World world = null;
        if (o.has("world")) {
            world = null;//Kakara.getGameInstance().getWorldManager().getWorldByUUID(UUID.fromString(o.get("world").getAsString()));
        }
        double x = o.get("x").getAsDouble();
        double y = o.get("y").getAsDouble();

        double z = o.get("z").getAsDouble();

        float pitch = 0;
        float yaw = 0;
        if (o.has("pitch")) {
            pitch = o.get("pitch").getAsFloat();
        }
        if (o.has("yaw")) {
            yaw = o.get("yaw").getAsFloat();
        }
        return new Location(world, x, y, z, pitch, yaw);
    }

    @Override
    public JsonElement serialize(Location location, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("x", location.getX());
        jsonObject.addProperty("y", location.getY());
        jsonObject.addProperty("z", location.getZ());
        jsonObject.addProperty("pitch", location.getPitch());
        jsonObject.addProperty("yaw", location.getYaw());
        location.getWorld().ifPresent(world -> {
            jsonObject.addProperty("world", world.getUUID().toString());
        });
        return jsonObject;
    }
}
