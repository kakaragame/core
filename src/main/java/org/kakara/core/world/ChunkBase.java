package org.kakara.core.world;

import org.kakara.core.charm.Charm;
import org.kakara.core.game.Item;
import org.kakara.core.game.ItemStack;
import org.kakara.core.game.MetaData;
import org.kakara.core.world.region.RegionFlag;
import org.kakara.core.world.region.RegionGrid;

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
    }

    public List<RegionFlag> getRegionFlags() {
        return regionFlags;
    }

    public RegionGrid getRegionGrid() {
        return regionGrid;
    }

    public int getX() {
        return x;
    }

    public int getZ() {
        return z;
    }

    public void setBlock(final int x, final int y, final int z, final Item item, final MetaData metaData) {
        gameBlocks.add(new GameBlock() {
            @Override
            public Location getLocation() {
                return new Location(world, x, y, z);
            }

            @Override
            public ItemStack getItemStack() {
                return new ItemStack() {
                    @Override
                    public Item getItem() {
                        return item;
                    }

                    @Override
                    public MetaData getMetaData() {
                        return metaData;
                    }

                    @Override public int getCount() { return 0; }
                    @Override public void setCount(int count) {}
                    @Override public Map<Charm, Byte> getCharms() { return new HashMap<>(); }
                    @Override public void addCharm(Charm charm, Byte level) {}
                };
            }
        });
    }

    public Chunk toChunk() {
        return () -> gameBlocks;
    }
}
