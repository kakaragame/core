package org.kakara.core.serializers.gson;

import com.google.gson.GsonBuilder;
import org.kakara.core.NameKey;
import org.kakara.core.game.ItemStack;
import org.kakara.core.player.OfflinePlayer;
import org.kakara.core.world.GameBlock;
import org.kakara.core.world.Location;
import org.kakara.core.world.World;

public class GsonSerializerRegistar {
    public static void registerSerializers(GsonBuilder builder) {
        builder.registerTypeAdapter(ItemStack.class, new ItemStackSerializer());
        builder.registerTypeAdapter(NameKey.class, new NameKeySerializer());
        builder.registerTypeAdapter(OfflinePlayer.class, new OfflinePlayerSerializer());
        builder.registerTypeAdapter(World.class, new WorldSerializer());
        builder.registerTypeAdapter(Location.class, new LocationSerializer());
        builder.registerTypeAdapter(GameBlock.class, new GameBlockSerializer());
    }
}
