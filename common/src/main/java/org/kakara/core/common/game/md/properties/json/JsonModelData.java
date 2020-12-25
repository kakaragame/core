package org.kakara.core.common.game.md.properties.json;

import org.kakara.core.common.game.md.ModelData;
import org.kakara.core.common.game.md.ModelDataObject;

import java.util.List;

public class JsonModelData implements ModelData {
    private final List<ModelDataObject> modelDataObjects;
    private final String defaultTexture;
    private final String defaultModel;

    public JsonModelData(List<ModelDataObject> modelDataObjects, String defaultTexture, String defaultModel) {
        this.modelDataObjects = modelDataObjects;
        this.defaultTexture = defaultTexture;
        this.defaultModel = defaultModel;
    }

    @Override
    public ModelDataObject getModelDataObject(int id) {
        return modelDataObjects.get(id);
    }

    @Override
    public String getDefaultTexture() {
        return defaultTexture;
    }

    @Override
    public String getDefaultModel() {
        return defaultModel;
    }
}
