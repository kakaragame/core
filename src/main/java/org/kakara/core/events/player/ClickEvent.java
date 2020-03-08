package org.kakara.core.events.player;

import org.kakara.core.player.Player;
import org.kakara.core.world.GameBlock;

public class ClickEvent extends PlayerEvent {
    private GameBlock gameBlock;

    public ClickEvent(Player player) {
        super(player);
    }

    public GameBlock getGameBlock() {
        return gameBlock;
    }
}
