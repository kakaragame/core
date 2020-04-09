package org.kakara.core.world;

import org.kakara.core.GameInstance;
import org.kakara.core.NameKey;
import org.kakara.core.mod.LoadStage;
import org.kakara.core.world.region.Region;

import java.util.List;

public interface WorldGenerationManager extends LoadStage {
    void registerRegion(Region region);

    void registerChunkGenerator(ChunkGenerator chunkGenerator);

    ChunkGenerator getGenerator(NameKey nameKey);

    default ChunkGenerator getGenerator(String s) {
        return getGenerator(new NameKey(s));
    }

    List<Region> getRegions();

    List<ChunkGenerator> getChunkGenerators();

    void load(GameInstance kakaraCore);
}
