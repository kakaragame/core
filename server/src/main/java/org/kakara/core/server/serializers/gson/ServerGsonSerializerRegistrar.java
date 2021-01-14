package org.kakara.core.server.serializers.gson;

import com.google.gson.GsonBuilder;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.serializers.gson.GsonSerializerRegistrar;
import org.kakara.core.common.world.GameBlock;
import org.kakara.core.common.world.Location;
import org.kakara.core.common.world.World;

public class ServerGsonSerializerRegistrar implements GsonSerializerRegistrar.GsonSubSerializerRegistrar {
    @Override
    public void registerSerializers(GsonBuilder builder) {
        builder.registerTypeAdapter(ItemStack.class, new ItemStackSerializer());
        //builder.registerTypeAdapter(OfflinePlayer.class, new OfflinePlayerSerializer());
        builder.registerTypeAdapter(World.class, new WorldSerializer());
        builder.registerTypeAdapter(Location.class, new LocationSerializer());
        builder.registerTypeAdapter(GameBlock.class, new GameBlockSerializer());
        //builder.registerTypeAdapter(ModInstance.class, new ModInstanceSerializer());
    }
}
