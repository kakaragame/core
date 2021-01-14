package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.common.game.ItemStack;
import org.kakara.core.common.world.region.RegionGrid;

import java.util.ArrayList;
import java.util.List;

public class ChunkBase {
    @NotNull
    private final World world;
    private final int x;
    private final int y;
    private final int z;
    @NotNull
    private final List<@NotNull GameBlock> gameBlocks;
    @Nullable
    private final RegionGrid regionGrid;

    public ChunkBase(@NotNull World world, int x, int y, int z, @Nullable RegionGrid regionGrid) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.gameBlocks = new ArrayList<>();
        this.regionGrid = regionGrid;
    }

    @NotNull
    public World getWorld() {
        return world;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public ChunkLocation toChunkLocation() {
        return new ChunkLocation(world, x, y, z);
    }

    @NotNull
    public List<@NotNull GameBlock> getGameBlocks() {
        return gameBlocks;
    }

    @Nullable
    public RegionGrid getRegionGrid() {
        return regionGrid;
    }

    public void setBlock(final int x, final int y, final int z, @NotNull final ItemStack itemStack) {
       gameBlocks.add(new GameBlock(new Location(world, x, y, z), itemStack));
    }
}
