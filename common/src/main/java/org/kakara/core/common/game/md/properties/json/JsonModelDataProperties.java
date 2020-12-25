package org.kakara.core.common.game.md.properties.json;

import org.kakara.core.common.game.md.ModelDataProperties;
import org.kakara.core.common.game.md.properties.ModelDataProperty;

import java.util.List;

public class JsonModelDataProperties implements ModelDataProperties {
    private final List<ModelDataProperty> propertyList;

    public JsonModelDataProperties(List<ModelDataProperty> propertyList) {
        this.propertyList = propertyList;
    }

    @Override
    public ModelDataProperty getProperty(String name) {
        return propertyList.stream().filter(modelDataProperty -> modelDataProperty.propertyName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
