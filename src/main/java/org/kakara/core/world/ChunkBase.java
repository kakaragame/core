package org.kakara.core.world;

import org.kakara.core.game.ItemStack;
import org.kakara.core.world.region.Region;
import org.kakara.core.world.region.RegionFlag;
import org.kakara.core.world.region.RegionGrid;

import java.util.ArrayList;
import java.util.List;

public class ChunkBase {
    private final World world;
    private final int x, y, z;
    private final List<RegionFlag> regionFlags;
    private final List<GameBlock> gameBlocks;
    private RegionGrid regionGrid;

    public ChunkBase(final World world, int x, int y, int z, List<RegionFlag> regionFlags, RegionGrid regionGrid) {
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;
        this.regionFlags = regionFlags;
        this.gameBlocks = new ArrayList<>();
        this.regionGrid = regionGrid;
    }

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
        gameBlocks.add(new GameBlock(new Location(world, x, y, z), itemStack));
    }
}
