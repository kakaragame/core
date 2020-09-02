package org.kakara.core;

public interface Identifiable {
    /**
     * The actual name of the item
     * *This is not the same value as the NameKey.getName*
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
     * The Name Key for the item
     *
     * @return the namekey for the item
     */
    NameKey getNameKey();

    /**
     * The key for the item
     *
     * @return the name key
     */
    String getKey();
}
