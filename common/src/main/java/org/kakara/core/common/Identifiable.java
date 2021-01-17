package org.kakara.core.common;

/**
 * Objects that implement this will have data that allows the game or the user to identify them.
 */
public interface Identifiable {
    /**
     * The actual name of the item
     *
     * @return the actual name
     */
    String getName();

    /**
     * The int id for the item
     *
     * @return the int id for the item
     */
    int getId();

    /**
     * The ControllerKey for the item
     *
     * @return the ControllerKey for the item
     */
    ControllerKey getControllerKey();

    /**
     * The key for the item
     * *Might be Removed*
     *
     * @return the name key
     */
    String getKey();
}
