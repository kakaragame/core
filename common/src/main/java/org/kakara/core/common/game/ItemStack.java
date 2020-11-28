package org.kakara.core.common.game;


import org.kakara.core.common.Serverable;

import java.util.List;

/**
 * Unlike an Item this represents an specific item in the game.
 * ex. damage data, Meta Data, and count.
 * <p>
 * To create a ItemStack use GameInstance#createItemStack(Item item)
 **/
public interface ItemStack extends Serverable {
    /**
     * This returns the item type this is
     *
     * @return the item.
     * @see Item
     */
    Item getItem();

    int getCount();

    String getName();


    List<String> getLore();

    boolean equalsIgnoreCount(ItemStack itemStack);
}
