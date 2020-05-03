package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.GameInstance;
import org.kakara.core.NameKey;
import org.kakara.core.mod.LoadStage;
import org.kakara.core.world.region.Region;

import java.util.List;

public interface WorldGenerationManager extends LoadStage {
    void registerRegion(@NotNull Region region);

    void registerChunkGenerator(@NotNull ChunkGenerator chunkGenerator);

    @Nullable
    ChunkGenerator getGenerator(NameKey nameKey);

    @Nullable
    default ChunkGenerator getGenerator(@NotNull String name) {
        return getGenerator(new NameKey(name));
    }

    @NotNull
    List<Region> getRegions();

    @NotNull
    List<ChunkGenerator> getChunkGenerators();

    void load(@NotNull GameInstance gameInstance);
}
