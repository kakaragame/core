package org.kakara.core.serializers.messagepack;

import org.apache.commons.lang3.CharSequenceUtils;
import org.kakara.core.Kakara;
import org.kakara.core.charm.Charm;
import org.kakara.core.data.Entry;
import org.kakara.core.data.Serializer;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemStackSerializer extends Serializer<ItemStack> {
    @Override
    public Entry disassembleObject(ItemStack item) {
        Map<String, Entry> map = new HashMap<>();
        map.put("i", new Entry(item.getItem().getNameKey().toString()));
        map.put("c", new Entry(item.getCount()));

        List<Entry> charms = new ArrayList<>();
        if (item.getCharms() != null) {
            item.getCharms().forEach((charm, aByte) ->
                    charms.add(new Entry(charm.getNameKey().toString() + "-" + aByte))
            );
        }

        map.put("m", new Entry(charms));
        map.put("n", new Entry(item.getName()));

        List<Entry> lore = new ArrayList<>();
        if (item.getCharms() != null) {
            item.getLore().forEach(s ->
                    lore.add(new Entry(s))
            );
        }
        map.put("l", new Entry(lore));

        return new Entry(map);
    }

    @Override
    public ItemStack assembleObject(Entry entry) {
        Map<String, Entry> map = entry.map();
        ItemStack itemStack = Kakara.createItemStack(Kakara.getItemManager().getItem(map.get("i").string()));

        itemStack.setCount(map.get("c").integer());
        itemStack.setName(map.get("n").string());

        List<String> lore = new ArrayList<>();
        for (Entry l : map.get("l").list()) {
            lore.add(l.string());
        }

        itemStack.setLore(lore);

        return itemStack;
    }
}
