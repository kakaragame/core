package org.kakara.core.events.player;

import org.kakara.core.events.HandlerList;
import org.kakara.core.player.Player;
import org.kakara.core.world.GameBlock;

/**
 * This is an event called when a Block is placed by a Player.
 */
public class PlaceEvent extends PlayerEvent {
    private GameBlock gameBlock;
    private static HandlerList handlerList = new HandlerList(PlaceEvent.class);

    public PlaceEvent(Player player, GameBlock gameBlock) {
        super(player);
        this.gameBlock = gameBlock;
    }

    /**
     * @return the GameBlock which was placed.
     */
    public GameBlock getGameBlock() {
        return gameBlock;
    }

    @Override
    public HandlerList getHandlerList() {
        return handlerList;
    }

    public static HandlerList getHandlers() {
        return handlerList;
    }
}
