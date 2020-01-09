package org.kakara.core.world.region;

import org.kakara.core.world.Location;

import java.util.Map;

public class RegionGrid {
    private Map<Location, Region> regions;

    public RegionGrid(Map<Location, Region> regions) {
        this.regions = regions;
    }

    public Region getRegion(int x, int z) {
        return regions.get(new Location(x, 60, z));
    }

    public void setRegion(int x, int z, Region region) {
        regions.put(new Location(x, 60, z), region);
    }
}
