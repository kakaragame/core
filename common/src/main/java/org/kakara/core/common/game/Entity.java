package org.kakara.core.common.game;


import org.kakara.core.common.Identifiable;
import org.kakara.core.common.game.entity.EntitySpawningPattern;
import org.kakara.core.common.game.entity.PathFinder;

public interface Entity extends Identifiable {

    String getModel();

    String getTexture();

    PathFinder getPathFinder();

    EntitySpawningPattern getEntitySpawningPattern();
}
