package org.kakara.core.server.serializers.ods;

import me.ryandw11.ods.ODS;
import me.ryandw11.ods.Tag;
import me.ryandw11.ods.tags.IntTag;
import me.ryandw11.ods.tags.ListTag;
import me.ryandw11.ods.tags.ObjectTag;
import me.ryandw11.ods.tags.StringTag;
import org.apache.commons.lang3.Validate;
import org.kakara.core.common.EnvType;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.game.Item;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.server.ServerGameInstance;
import org.kakara.core.server.game.ServerItemStack;


public class ItemStackTag extends ObjectTag {

    public ItemStackTag(String key, ItemStack stack) {
        super(key);

        addTag(new IntTag("item", stack.getItem().getId()));
        addTag(new IntTag("count", stack.getCount()));
//        Map<String, ByteTag> charms = new HashMap<>();
//        stack.getCharms().forEach((charm, byt) -> {
//            charms.put(charm.getName(), new ByteTag("", byt));
//        });
//        addTag(new MapTag<>("charms", charms));
        addTag(new StringTag("name", stack.getName()));
        addTag(ODS.wrap("lore", stack.getLore()));
    }

    public static ItemStack getItemStack(ObjectTag tag) {
        Validate.isTrue(Kakara.getEnvironmentInstance().getType() == EnvType.SERVER);
        Item item = Kakara.getGameInstance().getItemRegistry().getItem((Integer) tag.getTag("item").getValue());
        ServerItemStack itemStack = ((ServerGameInstance) Kakara.getGameInstance()).createItemStack(item);
        itemStack.setCount((Integer) tag.getTag("count").getValue());
        itemStack.setName(ODS.unwrap((StringTag) tag.getTag("name")));
        itemStack.setLore(ODS.unwrapListTag((ListTag<? extends Tag<String>>) tag.getTag("lore")));
        //TODO add support for charms.
        return itemStack;
    }

    public ItemStack getItemStack() {
        return getItemStack(this);
    }
}
