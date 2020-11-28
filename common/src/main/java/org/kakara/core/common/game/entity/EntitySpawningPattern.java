package org.kakara.core.common.game.entity;


import org.kakara.core.common.world.Location;
import org.kakara.core.common.world.World;

public interface EntitySpawningPattern {
    Location selectNewLocation(World world);
}
