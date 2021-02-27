package org.kakara.core.common.player.meter;

/**
 * Represents a level inside the players vitals
 */
public interface PlayerMeter {
    /**
     * Current Level
     *
     * @return the current level
     */
    double getLevel();



    /**
     * The meter type
     *
     * @return the meter
     */
    Meter getMeter();
}
