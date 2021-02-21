package org.kakara.core.common.player.meter;

/**
 * Kakara's default builtin meters
 */
public enum GameMeters implements Meter {
    /**
     * The health bar
     */
    HEALTH,
    HUNGER,
    ARMOUR;

    @Override
    public String getName() {
        return name();
    }
}
