package org.kakara.core.game;

import org.apache.commons.lang3.Validate;
import org.kakara.core.GameInstance;
import org.kakara.core.NameKey;
import org.kakara.core.Utils;
import org.kakara.core.mod.LoadStage;
import org.kakara.core.mod.Mod;

import java.util.List;
import java.util.Map;

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

    List<Item> getItemsByKey(String key);

    List<Item> getItems();

    void deregisterItems(String key);

    default Item getItem(String item) {
        return getItem(new NameKey(item.toLowerCase()));
    }

    Item getItem(NameKey item);

    default Block getBlock(String block) {
        Validate.notNull(block, "Block must not be null");
        Validate.isTrue(Utils.isValidItemPattern(block), "Must follow the following pattern MOD:BLOCK");
        Item item = getItem(block);
        if (item == null) return null;
        if (!(item instanceof Block)) return null;
        return ((Block) item);
    }

    void load(GameInstance GameInstance);
}
