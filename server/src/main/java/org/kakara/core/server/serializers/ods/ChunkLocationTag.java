package org.kakara.core.server.serializers.ods;

import me.ryandw11.ods.tags.IntTag;
import me.ryandw11.ods.tags.ObjectTag;
import me.ryandw11.ods.tags.StringTag;
import org.kakara.core.common.KValidate;
import org.kakara.core.common.Kakara;
import org.kakara.core.common.world.ChunkLocation;
import org.kakara.core.common.world.World;
import org.kakara.core.server.ServerGameInstance;

import java.util.UUID;

public class ChunkLocationTag extends ObjectTag {

    public ChunkLocationTag(String key, ChunkLocation loc) {
        super(key);
        if (loc.getWorld().isPresent())
            addTag(new StringTag("world", loc.getWorld().get().getUUID().toString()));
        addTag(new IntTag("x", loc.getX()));
        addTag(new IntTag("y", loc.getY()));
        addTag(new IntTag("z", loc.getZ()));
    }

    public static ChunkLocation getChunkLocation(ObjectTag tag) {
        World w = null;
        if (tag.hasTag("world"))
            KValidate.checkServer();
            w = ((ServerGameInstance) Kakara.getGameInstance()).getWorldManager().getWorldByUUID(UUID.fromString((String) tag.getTag("world").getValue()));
        int x = (Integer) tag.getTag("x").getValue();
        int y = (Integer) tag.getTag("y").getValue();
        int z = (Integer) tag.getTag("z").getValue();


        return new ChunkLocation(w, x, y, z);
    }

    public ChunkLocation getChunkLocation() {
        World w = null;
        if (hasTag("world"))
            KValidate.checkServer();
        w = ((ServerGameInstance) Kakara.getGameInstance()).getWorldManager().getWorldByUUID(UUID.fromString((String) getTag("world").getValue()));
        int x = (Integer) getTag("x").getValue();
        int y = (Integer) getTag("y").getValue();
        int z = (Integer) getTag("z").getValue();


        return new ChunkLocation(w, x, y, z);
    }

}
