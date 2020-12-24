package org.kakara.core.server.game;

import org.kakara.core.common.Serverable;
import org.kakara.core.common.exceptions.NoServerVersionAvailableException;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.game.meta.ItemMeta;

import java.util.List;

public interface ServerItemStack extends ItemStack {
    void setCount(int count);

    void setName(String name);

    void setLore(List<String> lore);

    void setItemMeta(ItemMeta itemMeta);

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
