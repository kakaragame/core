package org.kakara.core.common.test;

import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.game.SimpleGameObject;
import org.kakara.core.common.mod.Mod;

public abstract class ItemTest extends SimpleGameObject implements Item {
    private final String name;
    private final String texture;
private final String model;
private final ControllerKey controllerKey;

    public ItemTest(String name, String texture, String model, ControllerKey controllerKey) {
        this.name = name;
        this.texture = texture;
        this.model = model;
        this.controllerKey = controllerKey;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return controllerKey.hashCode();
    }

    @Override
    public String getTexture() {
        return texture;
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public ControllerKey getControllerKey() {
        return controllerKey;
    }

    @Override
    public String getKey() {
        return controllerKey.getKey();
    }

    @Override
    public Mod getMod() {
        return null;
    }
}