package org.kakara.core.events.player;

import org.kakara.core.player.Player;
import org.kakara.core.world.GameBlock;

public class PlaceEvent extends PlayerEvent {
    private GameBlock gameBlock;

    public PlaceEvent(Player player, GameBlock gameBlock) {
        super(player);
        this.gameBlock = gameBlock;
    }
}
