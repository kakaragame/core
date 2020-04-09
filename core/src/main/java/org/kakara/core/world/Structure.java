package org.kakara.core.world;

import org.kakara.core.world.region.RegionFlag;

public interface Structure {
    String getName();

    Schematic getSchematic();

    // false, it's like a bush or a rock pile
    // true, it's like
    boolean isCommendable();

    RegionFlag[] getRegionFlags();

    // 0-100 value, 0 being rare, 100 being like rocks, you find them everywhere
    int getRarity();
}
