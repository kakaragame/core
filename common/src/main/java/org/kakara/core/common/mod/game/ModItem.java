package org.kakara.core.common.mod.game;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.annotations.*;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.game.SimpleGameObject;
import org.kakara.core.common.game.md.ModelData;
import org.kakara.core.common.game.md.ModelDataLoader;
import org.kakara.core.common.mod.Mod;
import org.kakara.core.common.resources.ResourceType;

import java.util.Objects;

public abstract class ModItem extends SimpleGameObject implements Item {
    protected final ControllerKey nameKey;
    protected final GameMod mod;
    protected final String name;
    protected final int id;
    protected String texture;
    private ModelData modelData;

    public ModItem(GameMod mod) {
        super();
        this.mod = mod;
        Name nameA = getClass().getAnnotation(Name.class);
        this.name = nameA == null ? getClass().getSimpleName() : nameA.value();
        Key keyA = getClass().getAnnotation(Key.class);
        this.nameKey = new ControllerKey(mod, keyA == null ? getClass().getSimpleName() : keyA.value());
        this.id = nameKey.hashCode();
        texture = getClass().getAnnotation(Texture.class).value();
        if (getClass().isAnnotationPresent(ModelDataFile.class)) {
            modelData = ModelDataLoader.loadData(Kakara.getGameInstance().getResourceManager().getResource(getClass().getAnnotation(ModelDataFile.class).value(), ResourceType.OTHER, mod));
        }
    }

    protected void setModelData(ModelData modelData) {
        this.modelData = modelData;
    }

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public String getKey() {
        return nameKey.getKey();
    }

    @Override
    public String getTexture() {
        return texture;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ControllerKey getControllerKey() {
        return nameKey;
    }

    @Override
    public final int getId() {
        return id;
    }

    @Override
    public String getModel() {
        Model model = getClass().getAnnotation(Model.class);
        return model == null ? null : model.value();
    }

    @Override
    public Mod getMod() {
        return mod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ModItem modItem = (ModItem) o;
        return modItem.getId() == getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMod().getName());
    }
}
