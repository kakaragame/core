package org.kakara.core.serializers.gson;

import com.google.gson.*;
import org.kakara.core.Kakara;
import org.kakara.core.exceptions.MissingItemException;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemStack;

import java.lang.reflect.Type;

public class ItemStackSerializer implements JsonSerializer<ItemStack>, JsonDeserializer<ItemStack> {
    @Override
    public ItemStack deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject js = jsonElement.getAsJsonObject();
        Item item = Kakara.getItemManager().getItem(js.get("type").getAsString()).orElseThrow(RuntimeException::new);
        if (item == null) {
            throw new JsonParseException(new MissingItemException(js.get("type").getAsString()));

        }
        ItemStack stack = Kakara.createItemStack(item);
        stack.setCount(js.get("count").getAsInt());
        return stack;
    }

    @Override
    public JsonElement serialize(ItemStack itemStack, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", itemStack.getItem().getNameKey().toString());
        jsonObject.addProperty("name", itemStack.getName());
        jsonObject.addProperty("count", itemStack.getCount());
        jsonObject.add("lore", jsonSerializationContext.serialize(itemStack.getLore()));
        return jsonObject;
    }
}
