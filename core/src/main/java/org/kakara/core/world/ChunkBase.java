package org.kakara.core.world;

import org.kakara.core.game.ItemStack;
import org.kakara.core.world.region.Region;
import org.kakara.core.world.region.RegionFlag;
import org.kakara.core.world.region.RegionGrid;

import java.util.ArrayList;
import java.util.List;

public class ChunkBase {
    private ChunkLocation location;
    private final List<RegionFlag> regionFlags;
    private final List<GameBlock> gameBlocks;
    private RegionGrid regionGrid;

    public ChunkBase(final World world, int x, int y, int z, List<RegionFlag> regionFlags, RegionGrid regionGrid) {
        this(new ChunkLocation(world, x, y, z), regionFlags, regionGrid);
    }

    public ChunkBase(ChunkLocation chunkLocation, List<RegionFlag> regionFlags, RegionGrid regionGrid) {
        location = chunkLocation;
        this.regionFlags = regionFlags;
        this.gameBlocks = new ArrayList<>();
        this.regionGrid = regionGrid;
    }

    public World getWorld() {
        return location.getWorld().get();
    }

    public int getX() {
        return location.getX();
    }

    public int getY() {
        return location.getY();
    }

    public int getZ() {
        return location.getZ();
    }

    public List<RegionFlag> getRegionFlags() {
        return regionFlags;
    }

    public List<GameBlock> getGameBlocks() {
        return gameBlocks;
    }

    public RegionGrid getRegionGrid() {
        return regionGrid;
    }

    public void setRegionGrid(RegionGrid grid) {
        this.regionGrid = grid;
    }

    public void setBlock(final int x, final int y, final int z, final ItemStack itemStack) {
        gameBlocks.add(new GameBlock(new Location(location.getWorld().isPresent() ? location.getWorld().get() : null, x, y, z), itemStack));
    }
}
