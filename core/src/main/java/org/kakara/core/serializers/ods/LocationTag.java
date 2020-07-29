package org.kakara.core.serializers.ods;

import me.ryandw11.ods.tags.DoubleTag;
import me.ryandw11.ods.tags.FloatTag;
import me.ryandw11.ods.tags.ObjectTag;
import me.ryandw11.ods.tags.StringTag;
import org.kakara.core.Kakara;
import org.kakara.core.world.Location;
import org.kakara.core.world.World;

import java.util.UUID;

public class LocationTag extends ObjectTag {

    public LocationTag(String key, Location loc) {
        super(key);
        if (loc.getWorld().isPresent())
            addTag(new StringTag("world", loc.getWorld().get().getUUID().toString()));
        addTag(new DoubleTag("x", loc.getX()));
        addTag(new DoubleTag("y", loc.getY()));
        addTag(new DoubleTag("z", loc.getZ()));
        addTag(new FloatTag("yaw", loc.getYaw()));
        addTag(new FloatTag("pitch", loc.getPitch()));
    }

    public static Location getLocation(ObjectTag tag) {
        World w = null;
        if (tag.hasTag("world")) {
            w = Kakara.getWorldManager().getWorldByUUID(UUID.fromString((String) tag.getTag("world").getValue()));
        }
        double x = (Double) tag.getTag("x").getValue();
        double y = (Double) tag.getTag("y").getValue();
        double z = (Double) tag.getTag("z").getValue();
        float yaw = (Float) tag.getTag("yaw").getValue();
        float pitch = (Float) tag.getTag("pitch").getValue();
        return new Location(w, x, y, z, pitch, yaw);

    }


    public Location getLocation() {
        World w = null;
        if (hasTag("world"))
            w = Kakara.getWorldManager().getWorldByUUID(UUID.fromString((String) getTag("world").getValue()));
        double x = (Double) getTag("x").getValue();
        double y = (Double) getTag("y").getValue();
        double z = (Double) getTag("z").getValue();
        float yaw = (Float) getTag("yaw").getValue();
        float pitch = (Float) getTag("pitch").getValue();

        return new Location(w, x, y, z, pitch, yaw);
    }

}
