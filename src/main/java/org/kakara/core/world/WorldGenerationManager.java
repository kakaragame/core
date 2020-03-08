package org.kakara.core.world;

import org.kakara.core.KakaraCore;
import org.kakara.core.world.region.Region;

import java.util.List;

public interface WorldGenerationManager {
    void registerRegion(Region region);

    void registerChunkGenerator(ChunkGenerator chunkGenerator);

    List<Region> getRegions();

    List<ChunkGenerator> getChunkGenerators();

    void load(KakaraCore kakaraCore);
}
