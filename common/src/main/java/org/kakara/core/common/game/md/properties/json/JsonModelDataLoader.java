package org.kakara.core.common.game.md.properties.json;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.kakara.core.common.game.md.ModelData;
import org.kakara.core.common.game.md.ModelDataObject;
import org.kakara.core.common.game.md.properties.ModelDataProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JsonModelDataLoader {
    public static ModelData loadModelData(JsonObject object) {

        String defaultModel = object.get("default-model").getAsString();
        String defaultTexture = object.get("default-texture").getAsString();

        List<ModelDataObject> objectList = new ArrayList<>();
        if (object.has("models")) {
            int i = 1;
            for (JsonElement models : object.get("models").getAsJsonArray()) {
                List<ModelDataProperty> properties = new ArrayList<>();
                for (Map.Entry<String, JsonElement> stringJsonElementEntry : models.getAsJsonObject().entrySet()) {
                    String key = stringJsonElementEntry.getKey();

                    if (key.equalsIgnoreCase("TEXTURE")) {
                        properties.add(new BasicTextureProperty(stringJsonElementEntry.getValue().getAsJsonObject()));
                    } else if (key.equalsIgnoreCase("MODEL")) {
                        properties.add(new ModelProperty(stringJsonElementEntry.getValue().getAsJsonObject()));
                    }
                }
                i++;
                objectList.add(new ModelDataObject(new JsonModelDataProperties(properties), i));
            }
        }
        return new JsonModelData(objectList, defaultTexture, defaultModel);
    }
}
