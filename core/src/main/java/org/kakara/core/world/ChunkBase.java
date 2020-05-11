package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.Kakara;
import org.kakara.core.game.ItemStack;
import org.kakara.core.world.region.RegionGrid;

import java.util.ArrayList;
import java.util.List;

public class ChunkBase {
    @NotNull private final ChunkLocation chunkLocation;
    @NotNull private final List<GameBlock> gameBlocks;
    @Nullable private final RegionGrid regionGrid;

    public ChunkBase(@NotNull ChunkLocation chunkLocation, @NotNull List<GameBlock> gameBlocks, @Nullable RegionGrid regionGrid) {
        if (chunkLocation.getWorld() == null) {
            Kakara.LOGGER.error("ChunkBase locations may not have null as a value of world.");
        }

        this.chunkLocation = chunkLocation;
        this.gameBlocks = gameBlocks;
        this.regionGrid = regionGrid;
    }

    @NotNull
    public ChunkLocation getChunkLocation() {
        return chunkLocation;
    }

    @NotNull
    public List<GameBlock> getGameBlocks() {
        return gameBlocks;
    }

    @Nullable
    public RegionGrid getRegionGrid() {
        return regionGrid;
    }

    public void setBlock(int x, int y, int z, @NotNull ItemStack itemStack) {
        gameBlocks.add(new GameBlock(new Location(chunkLocation.getWorld(), x, y, z), itemStack));
    }
}
