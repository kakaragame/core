package org.kakara.core.common.player.meter;

/**
 * The class that controls the meters and levels in a player.
 *
 */
public interface PlayerMeterController {
    PlayerMeter getPlayerMeter(Meter meter);

    /**
     * Null is never returned. It will create the needed values if
     *
     * @param meters
     * @return
     */
    PlayerMeter getPlayerMeter(GameMeters meters);
}
