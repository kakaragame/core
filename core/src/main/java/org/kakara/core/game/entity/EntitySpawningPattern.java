package org.kakara.core.game.entity;

import org.kakara.core.world.Location;
import org.kakara.core.world.World;

public interface EntitySpawningPattern {
    Location selectNewLocation(World world);
}
