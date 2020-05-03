package org.kakara.core.world;

import org.kakara.core.world.region.RegionFlag;

public interface Structure {
    String getName();

    Schematic getSchematic();

    boolean isCommendable();

    RegionFlag[] getRegionFlags();

    int getRarity();
}
