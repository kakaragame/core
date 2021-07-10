package org.kakara.core.common.game.md;

public interface ModelData {
    ModelDataObject getModelDataObject(int id);

    String getDefaultTexture();

    String getDefaultModel();
}
