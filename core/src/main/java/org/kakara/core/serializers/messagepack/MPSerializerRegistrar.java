package org.kakara.core.serializers.messagepack;

import org.kakara.core.Kakara;
import org.kakara.core.data.SerializerManager;
import org.kakara.core.game.ItemStack;
import org.kakara.core.world.GameBlock;
import org.kakara.core.world.Location;
import org.kakara.core.world.World;

public class MPSerializerRegistrar {
    static final LocationOldSerializer LOCATION_SERIALIZER = new LocationOldSerializer();
    static final WorldOldSerializer WORLD_SERIALIZER = new WorldOldSerializer();
    static final ItemStackOldSerializer ITEM_STACK_SERIALIZER = new ItemStackOldSerializer();
    static final GameBlockOldSerializer GAME_BLOCK_SERIALIZER = new GameBlockOldSerializer();

    public static void load() {
        SerializerManager s = Kakara.getSerializerManager();
        s.register(Location.class, LOCATION_SERIALIZER);
        s.register(World.class, WORLD_SERIALIZER);
        s.register(ItemStack.class, ITEM_STACK_SERIALIZER);
        s.register(GameBlock.class, GAME_BLOCK_SERIALIZER);
    }
}
