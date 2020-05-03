package org.kakara.core.game;


import org.kakara.core.charm.Charm;

import java.util.List;
import java.util.Map;

/**
 * Unlike an Item this represents an specific item in the game.
 * ex. damage data, Meta Data, and count.
 * <p>
 * To create a ItemStack use GameInstance#createItemStack(Item item)
 **/
public interface ItemStack {
    /**
     * This returns the item type this is
     *
     * @return the item.
     * @see Item
     */
    Item getItem();

    int getCount();

    void setCount(int count);

    Map<Charm, Byte> getCharms();

    void addCharm(Charm charm, Byte level);

    String getName();

    void setName(String name);

    List<String> getLore();

    void setLore(List<String> lore);
}
