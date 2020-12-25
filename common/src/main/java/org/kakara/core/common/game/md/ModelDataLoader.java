package org.kakara.core.common.game.md;

import com.google.gson.JsonObject;
import org.kakara.core.common.Utils;
import org.kakara.core.common.game.md.properties.json.JsonModelDataLoader;
import org.kakara.core.common.resources.Resource;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ModelDataLoader {
    public static ModelData loadData(Resource resource) {
        try {
            JsonObject jsonObject = Utils.getGson().fromJson(new FileReader(resource.getFile()), JsonObject.class);
            return JsonModelDataLoader.loadModelData(jsonObject);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
