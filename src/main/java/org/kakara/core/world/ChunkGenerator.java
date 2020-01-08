package org.kakara.core.world;

import java.util.List;
import java.util.Map;

public interface ChunkGenerator {
    enum RegionFlag {

    }

    class RegionGrid {
        Map<Location, Region> regions;

        public Region getRegion(int x, int z) {
            return regions.get(new Location(x, 60, z));
        }

        public void setRegion(int x, int z, Region region) {
            regions.put(new Location(x, 60, z), region);
        }
    }

    Chunk generateChunk(World world, int x, int z, List<RegionFlag> regionFlags, RegionGrid regionGrid);
}
