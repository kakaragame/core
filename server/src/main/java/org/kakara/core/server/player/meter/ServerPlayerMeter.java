package org.kakara.core.server.player.meter;

import org.kakara.core.common.player.meter.PlayerMeter;

public interface ServerPlayerMeter extends PlayerMeter {
    /**
     * Change the current level
     *
     * @param level the level
     */
    void setLevel(double level);
}
