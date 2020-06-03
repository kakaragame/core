package org.kakara.core.player;

import org.kakara.core.NameKey;
import org.kakara.core.game.entity.EntitySpawningPattern;
import org.kakara.core.game.entity.PathFinder;

public class PlayerEntity extends HumanoidEntity {
    private NameKey nameKey = new NameKey("kakara", "player");
    private String name;

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
    public NameKey getNameKey() {
        return nameKey;
    }

    @Override
    public PathFinder getPathFinder() {
        return null;
    }

    @Override
    public EntitySpawningPattern getEntitySpawningPattern() {
        return world -> null;
    }
}
