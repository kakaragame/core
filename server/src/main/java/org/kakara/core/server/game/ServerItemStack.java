package org.kakara.core.server.game;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.common.Serverable;
import org.kakara.core.common.exceptions.NoServerVersionAvailableException;
import org.kakara.core.common.game.ItemStack;

import java.util.List;

public interface ServerItemStack extends ItemStack {
    /**
     * Sets the number of items in the stack
     *
     * @param count
     */
    void setCount(int count);

    /**
     * sets the name
     *
     * @param name the new name
     */
    void setName(@NotNull String name);

    /**
     * Sets the lore
     *
     * @param lore the item lore. Can be null
     */
    void setLore(@Nullable List<String> lore);

    /**
     * Clones the ItemStack exactly how it is now.
     * @return the cloned ItemStack
     */
    ItemStack clone();

    @Override
    default boolean isServerVersionAvailable() {
        return true;
    }

    @Override
    default <T extends Serverable> T getServerVersion() {
        return (T) this;
    }

    @Override
    default void requiresServerVersion() throws NoServerVersionAvailableException {

    }
}
