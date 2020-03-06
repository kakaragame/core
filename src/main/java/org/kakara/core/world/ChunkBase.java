package org.kakara.core.world;

import org.kakara.core.charm.Charm;
import org.kakara.core.game.ItemStack;
import org.kakara.core.game.MetaData;
import org.kakara.core.world.region.RegionFlag;
import org.kakara.core.world.region.RegionGrid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChunkBase {
    private World world;
    private int x, z;
    private List<RegionFlag> regionFlags;
    private RegionGrid regionGrid;
    private List<GameBlock> gameBlocks;

    public ChunkBase(final World world, int x, int z, List<RegionFlag> regionFlags, RegionGrid regionGrid) {
        this.world = world;
        this.x = x;
        this.z = z;
        this.regionFlags = regionFlags;
        this.regionGrid = regionGrid;
        this.gameBlocks = new ArrayList<>();
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

    public RegionGrid getRegionGrid() {
        return regionGrid;
    }

    public List<GameBlock> getGameBlocks() {
        return gameBlocks;
    }

    public void setBlock(final int x, final int y, final int z, final ItemStack itemStack, final MetaData metaData) {
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
