package org.kakara.core.server.serializers.gson;

import com.google.gson.*;
import org.apache.commons.lang3.Validate;
import org.kakara.core.common.EnvType;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.exceptions.MissingItemException;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.server.ServerGameInstance;
import org.kakara.core.server.game.ServerItemStack;

import java.lang.reflect.Type;

public class ItemStackSerializer implements JsonSerializer<ItemStack>, JsonDeserializer<ItemStack> {
    private final ServerGameInstance serverGameInstance;

    public ItemStackSerializer() {
        Validate.isTrue(Kakara.getEnvironmentInstance().getType() == EnvType.SERVER);
        this.serverGameInstance = (ServerGameInstance) Kakara.getGameInstance();
    }

    @Override
    public ItemStack deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        Validate.isTrue(Kakara.getEnvironmentInstance().getType() == EnvType.SERVER);
        JsonObject js = jsonElement.getAsJsonObject();
        Item item = null;//Kakara.getItemManager().getItem(js.get("type").getAsString());
        if (item == null) {
            throw new JsonParseException(new MissingItemException(js.get("type").getAsString()));

        }
        ServerItemStack stack = serverGameInstance.createItemStack(item);
        stack.setCount(js.get("count").getAsInt());
        return stack;
    }

    @Override
    public JsonElement serialize(ItemStack itemStack, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", itemStack.getItem().getControllerKey().toString());
        jsonObject.addProperty("name", itemStack.getName());
        jsonObject.addProperty("count", itemStack.getCount());
        jsonObject.add("lore", jsonSerializationContext.serialize(itemStack.getLore()));
        return jsonObject;
    }
}
