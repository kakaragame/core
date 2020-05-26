package org.kakara.core.serializers.ods;

import me.ryandw11.ods.ODS;
import me.ryandw11.ods.Tag;
import me.ryandw11.ods.tags.*;
import org.kakara.core.Kakara;
import org.kakara.core.game.ItemStack;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStackTag extends ObjectTag {

    public ItemStackTag(String key, ItemStack stack){
        super(key);

        addTag(new StringTag("item", stack.getItem().getName()));
        addTag(new IntTag("count", stack.getCount()));
//        Map<String, ByteTag> charms = new HashMap<>();
//        stack.getCharms().forEach((charm, byt) -> {
//            charms.put(charm.getName(), new ByteTag("", byt));
//        });
//        addTag(new MapTag<>("charms", charms));
        addTag(new StringTag("name", stack.getName()));
        addTag(ODS.wrap("lore", stack.getLore()));
    }

    public ItemStack getItemStack(){
        ItemStack itemStack = Kakara.createItemStack(Kakara.getItemManager().getItem((String) getTag("item").getValue()).orElseThrow(() -> new RuntimeException("TODO make ItemNotFoundException")));
        itemStack.setCount((Integer) getTag("count").getValue());
        itemStack.setName(ODS.unwrap((StringTag) getTag("name")));
        itemStack.setLore(ODS.unwrapListTag((ListTag<? extends Tag<String>>) getTag("lore")));
        //TODO add support for charms.
        return itemStack;
    }
}
