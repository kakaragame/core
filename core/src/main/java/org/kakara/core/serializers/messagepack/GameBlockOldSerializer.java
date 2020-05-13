package org.kakara.core.serializers.messagepack;

import org.kakara.core.data.Entry;
import org.kakara.core.data.OldSerializer;
import org.kakara.core.game.ItemStack;
import org.kakara.core.world.GameBlock;
import org.kakara.core.world.Location;

import java.util.HashMap;
import java.util.Map;

public class GameBlockOldSerializer extends OldSerializer<GameBlock> {
    @Override
    public Entry disassembleObject(GameBlock item) {
        Map<String, Entry> entries = new HashMap<>();
        entries.put("l", MPSerializerRegistrar.LOCATION_SERIALIZER.disassembleObject(item.getLocation()));
        entries.put("i", MPSerializerRegistrar.ITEM_STACK_SERIALIZER.disassembleObject(item.getItemStack()));

        return new Entry(entries);
    }

    @Override
    public GameBlock assembleObject(Entry entry) {
        Location location = MPSerializerRegistrar.LOCATION_SERIALIZER.assembleObject(entry.map().get("l"));
        ItemStack itemStack = MPSerializerRegistrar.ITEM_STACK_SERIALIZER.assembleObject(entry.map().get("i"));

        return new GameBlock(location, itemStack);
    }
}
