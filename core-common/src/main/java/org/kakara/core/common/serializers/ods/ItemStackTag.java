package org.kakara.core.common.serializers.ods;

import me.ryandw11.ods.ODS;
import me.ryandw11.ods.Tag;
import me.ryandw11.ods.tags.IntTag;
import me.ryandw11.ods.tags.ListTag;
import me.ryandw11.ods.tags.ObjectTag;
import me.ryandw11.ods.tags.StringTag;
import org.kakara.core.common.Kakara;
import org.kakara.core.game.game.ItemStack;

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
        ItemStack itemStack = Kakara.createItemStack(Kakara.getItemManager().getItem((Integer) tag.getTag("item").getValue()));
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
