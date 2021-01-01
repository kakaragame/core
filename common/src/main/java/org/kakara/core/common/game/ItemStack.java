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

    /**
     * Number of items inside stack
     *
     * @return number of items inside stack
     */
    int getCount();

    /**
     * Returns the Item name
     *
     * @return name of the item.
     */
    String getName();

    /**
     * Returns the Item lore.
     *
     * @return item lore. Null if not present.
     */
    List<String> getLore();

    /**
     * Compares against another item stack. Ignoring the count
     *
     * @param itemStack the other ItemStack
     * @return if they are equal
     */
    boolean equalsIgnoreCount(ItemStack itemStack);
}
