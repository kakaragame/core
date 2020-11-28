package org.kakara.core.common.game;

import java.util.Set;

import static org.kakara.core.common.game.GameModeProperties.*;

public enum DefaultGameMode implements GameMode {
    CREATIVE(Set.of(CREATIVE_INVENTORY, INSTANT_BREAKING, UNBREAKABLE, CAN_FLY)),
    SURVIVAL(Set.of(SURVIVAL_INVENTORY));
    private final Set<String> properties;

    DefaultGameMode(Set<String> properties) {
        this.properties = properties;
    }

    @Override
    public Set<String> getProperties() {
        return properties;
    }

    @Override
    public String getName() {
        return name();
    }
}

