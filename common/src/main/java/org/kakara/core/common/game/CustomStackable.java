package org.kakara.core.common.game;

/**
 * If the Item implements this the createItemStack method will be invoked to get the ItemStack
 */
public interface CustomStackable {
    /**
     * Create a custom ItemStack with your item.
     *
     * @return the custom item stack
     */
    ItemStack createItemStack();

    /**
     * Create a custom ServerItemStack with your item.
     *
     * @return the custom item stack
     */
    ItemStack createServerItemStack();
}
