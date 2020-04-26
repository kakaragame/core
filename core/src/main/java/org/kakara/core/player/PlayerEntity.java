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
    public String getModel() {
        //TODO Use Player Model Service type thing
        return null;
    }

    @Override
    public String getId() {
        return nameKey.getName();
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
        return null;
    }
}
