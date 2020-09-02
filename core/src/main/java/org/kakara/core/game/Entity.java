package org.kakara.core.game;

import org.kakara.core.Identifiable;
import org.kakara.core.game.entity.EntitySpawningPattern;
import org.kakara.core.game.entity.PathFinder;

public interface Entity extends Identifiable {

    String getModel();

    String getTexture();

    PathFinder getPathFinder();

    EntitySpawningPattern getEntitySpawningPattern();
}
