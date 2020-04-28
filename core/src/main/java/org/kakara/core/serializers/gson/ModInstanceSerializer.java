package org.kakara.core.serializers.gson;

import com.google.gson.*;
import org.kakara.core.modinstance.ModInstance;
import org.kakara.core.modinstance.ModInstanceBuilder;
import org.kakara.core.modinstance.ModInstanceType;
import org.kakara.core.world.GameBlock;

import java.io.File;
import java.lang.reflect.Type;

public class ModInstanceSerializer implements JsonSerializer<ModInstance>, JsonDeserializer<ModInstance> {
    @Override
    public ModInstance deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject object = jsonElement.getAsJsonObject();
        ModInstanceBuilder builder = new ModInstanceBuilder();
        builder.setName(object.get("name").getAsString());
        builder.setModServer(object.get("server").getAsString());
        builder.setModVersion(object.get("version").getAsString());
        builder.setType(ModInstanceType.valueOf(object.get("type").getAsString()));
        builder.setModFile(new File(object.get("file").getAsString()));
        //TODO grab setting
        return builder.createModInstance();
    }

    @Override
    public JsonElement serialize(ModInstance modInstance, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("server", modInstance.getModServer());
        jsonObject.addProperty("version", modInstance.getModVersion());
        jsonObject.addProperty("name", modInstance.getName());
        jsonObject.addProperty("type", modInstance.getType().name());
        jsonObject.addProperty("file", modInstance.getModFile().getAbsolutePath());
        //TODO implement settings
        jsonObject.add("settings", JsonNull.INSTANCE);
        return jsonObject;
    }
}
