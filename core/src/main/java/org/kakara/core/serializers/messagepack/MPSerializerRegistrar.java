package org.kakara.core.serializers.messagepack;

import org.kakara.core.Kakara;
import org.kakara.core.data.SerializerManager;
import org.kakara.core.game.ItemStack;
import org.kakara.core.world.GameBlock;
import org.kakara.core.world.Location;
import org.kakara.core.world.World;

public class MPSerializerRegistrar {
    static final LocationSerializer LOCATION_SERIALIZER = new LocationSerializer();
    static final WorldSerializer WORLD_SERIALIZER = new WorldSerializer();
    static final ItemStackSerializer ITEM_STACK_SERIALIZER = new ItemStackSerializer();
    static final GameBlockSerializer GAME_BLOCK_SERIALIZER = new GameBlockSerializer();

    public static void load() {
        SerializerManager s = Kakara.getSerializerManager();
        s.register(Location.class, LOCATION_SERIALIZER);
        s.register(World.class, WORLD_SERIALIZER);
        s.register(ItemStack.class, ITEM_STACK_SERIALIZER);
        s.register(GameBlock.class, GAME_BLOCK_SERIALIZER);
    }
}
