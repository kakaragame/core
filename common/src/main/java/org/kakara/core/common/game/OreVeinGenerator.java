package org.kakara.core.common.game;


import org.kakara.core.common.world.Schematic;

public interface OreVeinGenerator {
    Schematic generate(Ore ore);
}
