package org.kakara.core.events.player.click;

import org.kakara.core.events.player.PlayerEvent;
import org.kakara.core.player.Player;
import org.kakara.core.world.GameBlock;

/**
 * This is an event called when a Block is clicked by a Player.
 */
public class ClickEvent extends PlayerEvent {
    private GameBlock gameBlock;
    private ClickType clickType;
    private MouseButtonType mouseButtonType;

    /**
     * @param player the Player used by the event.
     * @param gameBlock the GameBlock which was clicked.
     * @param clickType the type of click.
     * @param mouseButtonType the mouse button used to click.
     */
    public ClickEvent(Player player, GameBlock gameBlock, ClickType clickType, MouseButtonType mouseButtonType) {
        super(player);
        this.gameBlock = gameBlock;
        this.clickType = clickType;
        this.mouseButtonType = mouseButtonType;
    }

    /**
     * @return the GameBlock which was clicked.
     */
    public GameBlock getGameBlock() {
        return gameBlock;
    }

    /**
     * @return the type of click.
     */
    public ClickType getClickType() {
        return clickType;
    }

    /**
     * @return the mouse button used to click.
     */
    public MouseButtonType getMouseButtonType() {
        return mouseButtonType;
    }
}
