package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.common.ControllerKey;
import org.kakara.core.common.GameInstance;
import org.kakara.core.common.mod.LoadStage;
import org.kakara.core.common.world.region.Region;

import java.util.List;

public interface WorldGenerationRegistry extends LoadStage {
    void registerRegion(@NotNull Region region);

    void registerChunkGenerator(@NotNull WorldGenerator worldGenerator);

    @Nullable
    WorldGenerator getGenerator(ControllerKey nameKey);

    @Nullable
    default WorldGenerator getGenerator(@NotNull String name) {
        return getGenerator(new ControllerKey(name));
    }

    @NotNull
    List<Region> getRegions();

    @NotNull
    List<WorldGenerator> getChunkGenerators();

    void load(@NotNull GameInstance gameInstance);
}
