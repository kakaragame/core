package org.kakara.core.game.game;

import org.kakara.core.world.Schematic;

public interface OreVeinGenerator {
    Schematic generate(Ore ore);
}
