package org.kakara.core.common.player;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.game.entity.EntitySpawningPattern;
import org.kakara.core.common.game.entity.PathFinder;
import org.kakara.core.common.mod.Mod;

public class PlayerEntity extends HumanoidEntity {
    private final ControllerKey nameKey = new ControllerKey("kakara", "player");
    private final String name;

    public PlayerEntity(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getModel() {
        //TODO Use Player Model Service type thing
        return null;
    }

    @Override
    public String getTexture() {
        return null;
    }

    @Override
    public ControllerKey getControllerKey() {
        return nameKey;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public PathFinder getPathFinder() {
        return null;
    }

    @Override
    public EntitySpawningPattern getEntitySpawningPattern() {
        return world -> null;
    }

    @Override
    public Mod getMod() {
        return null;
    }
}
