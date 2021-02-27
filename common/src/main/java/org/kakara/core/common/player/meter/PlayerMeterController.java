package org.kakara.core.common.player.meter;

/**
 * The class that controls the meters and levels in a player.
 */
public interface PlayerMeterController {
    /**
     * Null is never returned. It will create the needed values if
     *
     * @param meter
     * @return the player meter.
     */
    PlayerMeter getPlayerMeter(Meter meter);


}
