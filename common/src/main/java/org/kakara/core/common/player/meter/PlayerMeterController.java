package org.kakara.core.common.player.meter;

public interface PlayerMeterController {
    PlayerMeter getPlayerMeter(Meter meter);

    /**
     * Null is never returned. It will create the needed values if
     * @param meters
     * @return
     */
    PlayerMeter getPlayerMeter(GameMeters meters);
}
