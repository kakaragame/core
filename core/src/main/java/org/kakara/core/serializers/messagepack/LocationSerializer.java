package org.kakara.core.serializers.messagepack;

import org.kakara.core.Kakara;
import org.kakara.core.data.Entry;
import org.kakara.core.data.Serializer;
import org.kakara.core.world.Location;
import org.kakara.core.world.World;

import java.util.HashMap;
import java.util.Map;

public class LocationSerializer extends Serializer<Location> {
    @Override
    public Entry disassembleObject(Location l) {
        Map<String, Entry> map = new HashMap<>();
        map.put("x", new Entry(l.getX()));
        map.put("y", new Entry(l.getY()));
        map.put("z", new Entry(l.getZ()));
        map.put("p", new Entry(l.getPitch()));
        map.put("a", new Entry(l.getYaw()));
        if (l.getWorld() != null) map.put("w", new Entry(l.getWorld().getUUID()));

        return new Entry(map);
    }

    @Override
    public Location assembleObject(Entry entry) {
        Map<String, Entry> map = entry.map();
        double x = map.get("x").doubleNumber();
        double y = map.get("y").doubleNumber();
        double z = map.get("z").doubleNumber();
        float pitch = map.get("p").floatNumber();
        float yaw = map.get("a").floatNumber();

        World world = null;
        if (map.containsKey("w")) world = Kakara.getWorldManager().getWorldByUUID(map.get("w").uuid());

        return new Location(world, x, y, z, pitch, yaw);
    }
}
