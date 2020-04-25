package org.kakara.core.game;

import org.kakara.core.NameKey;
import org.kakara.core.game.entity.EntitySpawningPattern;
import org.kakara.core.game.entity.PathFinder;

public interface Entity {
    String getName();

    String getModel();

    String getId();

    NameKey getNameKey();

    PathFinder getPathFinder();

    EntitySpawningPattern getEntitySpawningPattern();
}
