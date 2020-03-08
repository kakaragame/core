package org.kakara.core.world;

import org.kakara.core.game.ItemStack;
import org.kakara.core.game.MetaData;
import org.kakara.core.world.region.RegionFlag;
import org.kakara.core.world.region.RegionGrid;

import java.util.ArrayList;
import java.util.List;

public class ChunkBase {
    private World world;
    private int x, z;
    private List<RegionFlag> regionFlags;
    private List<GameBlock> gameBlocks;
    private RegionGrid regionGrid;

    public ChunkBase(final World world, int x, int z, List<RegionFlag> regionFlags) {
        this.world = world;
        this.x = x;
        this.z = z;
        this.regionFlags = regionFlags;
        this.gameBlocks = new ArrayList<>();
    }

    public World getWorld() {
        return world;
    }

    public int getX() {
        return x;
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
        gameBlocks.add(new GameBlock() {
            @Override
            public Location getLocation() {
                return new Location(world, x, y, z);
            }

            @Override
            public ItemStack getItemStack() {
                return itemStack;
            }
        });
    }

    public Chunk toChunk() {
        return () -> gameBlocks;
    }
}
