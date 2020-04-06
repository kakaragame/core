package org.kakara.core.world;

import org.kakara.core.game.Block;
import org.kakara.core.game.ItemStack;
import org.kakara.core.player.Player;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

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

    default CompletableFuture<Chunk> getChunkAt(int x, int y, int z) {
        return getChunkAt(new ChunkLocation(x, y, z));
    }

    CompletableFuture<Chunk> getChunkAt(ChunkLocation location);

    void unloadChunk(Chunk chunk);

    void loadChunk(Chunk chunk);

    default boolean isChunkLoaded(int x, int y, int z) {
        return isChunkLoaded(new ChunkLocation(x, y, z));
    }

    boolean isChunkLoaded(ChunkLocation location);

    Chunk[] getLoadedChunks();

}
