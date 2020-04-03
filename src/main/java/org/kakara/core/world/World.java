package org.kakara.core.world;

import org.kakara.core.game.Block;
import org.kakara.core.game.ItemStack;
import org.kakara.core.player.Player;

import java.util.UUID;

public interface World {

    Chunk[] getChunks();

    UUID getUUID();

    String getName();

    GameBlock getBlockAt(int x, int y, int z);

    GameBlock getBlockAt(Location location);

    GameBlock setBlock(ItemStack itemStack, Location location);

    GameBlock setBlock(Block block, Location location);

    Location getWorldSpawn();

    void setWorldSpawn(Location location);

    Chunk getChunkAt(int x, int z);

    Chunk getChunkAt(Location location);

    void loadChunk(Chunk chunk);

    boolean isChunkLoaded(int x, int z);

    Chunk[] getLoadedChunks();

}
