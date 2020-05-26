package org.kakara.core.serializers.ods;

import me.ryandw11.ods.tags.*;
import org.kakara.core.Kakara;
import org.kakara.core.world.ChunkLocation;
import org.kakara.core.world.World;

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

    public ChunkLocation getChunkLocation() {
        World w = null;
        if (hasTag("world"))
            w = Kakara.getWorldManager().getWorldByUUID(UUID.fromString((String) getTag("world").getValue()));
        int x = (Integer) getTag("x").getValue();
        int y = (Integer) getTag("y").getValue();
        int z = (Integer) getTag("z").getValue();
        ;

        return new ChunkLocation(w, x, y, z);
    }

}
