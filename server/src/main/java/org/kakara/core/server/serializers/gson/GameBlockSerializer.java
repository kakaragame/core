package org.kakara.core.server.serializers.gson;

import com.google.gson.*;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.world.GameBlock;
import org.kakara.core.common.world.Location;

import java.lang.reflect.Type;

public class GameBlockSerializer implements JsonSerializer<GameBlock>, JsonDeserializer<GameBlock> {

    @Override
    public GameBlock deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject js = jsonElement.getAsJsonObject();
        return new GameBlock(jsonDeserializationContext.deserialize(js.get("location"), Location.class), jsonDeserializationContext.deserialize(js.get("item"), ItemStack.class));
    }

    @Override
    public JsonElement serialize(GameBlock gameBlock, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("location", jsonSerializationContext.serialize(gameBlock.getLocation(), Location.class));
        jsonObject.add("item", jsonSerializationContext.serialize(gameBlock.getItemStack(), ItemStack.class));
        return jsonObject;
    }
}
