package org.kakara.core.game;

import org.kakara.core.GameInstance;
import org.kakara.core.NameKey;
import org.kakara.core.mod.LoadStage;

import java.util.List;
import java.util.Optional;

public interface ItemManager extends LoadStage {
    /**
     * Call this method if you want to register a Item, Block, Tool, or Weapon.
     * The Item does not be to be a sub type of ModBlock, ModItem, ModTool, or ModWeapon. Those classes just make things simple.
     * <p>
     * Please register the resources required before calling this method. If you fail to do that. You will receive a ResourceNotFoundException.
     *
     * @param item This can be anything that extends an Item(Item, Block, Tool, or Weapon)
     */
    void registerItem(Item item);

    void deregisterItem(Item item);

    List<Item> getItemsByName(String name);

    List<Item> getItems();

    void deregisterItems(String key);

    default Optional<Item> getItem(String item) {
        return getItem(new NameKey(item.toLowerCase()));
    }

    default Optional<Item> getItem(NameKey item) {
        return getItem(item.hashCode());
    }

    Optional<Item> getItem(int id);

    void load(GameInstance GameInstance);
}
