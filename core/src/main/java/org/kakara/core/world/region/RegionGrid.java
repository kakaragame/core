package org.kakara.core.world.region;

public interface RegionGrid {
    Region getRegion(int x, int z);

    void setRegion(int x, int z, Region region);
}
