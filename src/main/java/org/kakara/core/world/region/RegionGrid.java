package org.kakara.core.world.region;

import org.kakara.core.world.Location;

import java.util.Map;

public interface RegionGrid {
    Region getRegion(int x, int z);

    void setRegion(int x, int z, Region region);
}
