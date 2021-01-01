package org.kakara.core.common.game;


import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.GameObject;
import org.kakara.core.common.Identifiable;
import org.kakara.core.common.mod.Mod;

/**
 * This represents an Item in a game.
 * <p>
 * This is not the Item you hold. ItemStacks are the item you hold. This is just what tells the game about the Item.
 */
public interface Item extends Identifiable, GameObject {
    /**
     * The Item name.
     *
     * @return the item name.
     */
    String getName();

    String getTexture();

    String getModel();

    /**
     * The controller key for the item
     *
     * @return the ControllerKey
     */
    ControllerKey getControllerKey();

    Mod getMod();


    //void onClick(ClickEvent clickEvent);
}
