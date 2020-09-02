package org.kakara.core.charm;

import org.kakara.core.Identifiable;
import org.kakara.core.game.Item;

/**
 * This defines a type of charm in Kakara used to modify items in specific ways.
 */
public interface Charm extends Identifiable {
    /**
     * @return the maximum usable level for the charm.
     */
    byte getMaximumLevel();

    /**
     * @return the array of specific items which this charm can be applied to.
     * This can be left empty if you want only applicable item types.
     */
    Item[] getApplicableItems();

    /**
     * @return the array of item types which this charm can be applied to.
     * This can be left empty if you want only specific items to accept this charm.
     */
    Class<? extends Item>[] getApplicableItemTypes();

    /**
     * @return an array of charms which are incompatible and cannot be used with this one.
     * It does not matter if only one of the charms or both of the charms add each-other in this list, the end result is the same.
     */
    Charm[] getIncompatibleCharms();
}
