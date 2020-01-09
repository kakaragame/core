package org.kakara.core.world;

import org.kakara.core.world.region.RegionFlag;
import org.kakara.core.world.region.RegionGrid;

import java.util.List;
import java.util.Map;

public interface ChunkGenerator {


    Chunk generateChunk(World world, int x, int z, List<RegionFlag> regionFlags, RegionGrid regionGrid);
}
