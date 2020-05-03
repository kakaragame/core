package org.kakara.core.world;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.game.Block;
import org.kakara.core.game.ItemStack;
import org.kakara.core.player.Player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public interface World {
    @NotNull
    Chunk[] getChunks();

    @NotNull
    UUID getUUID();

    @NotNull
    String getName();

    @NotNull
    Optional<GameBlock> getBlockAt(int x, int y, int z);

    @NotNull
    Optional<GameBlock> getBlockAt(Location location);

    @NotNull
    Optional<GameBlock> setBlock(@NotNull ItemStack itemStack, @NotNull Location location);

    @NotNull
    Optional<GameBlock> setBlock(@Nullable Block block, @NotNull Location location);

    @NotNull
    Location getWorldSpawn();

    void setWorldSpawn(@NotNull Location location);

    @NotNull
    default CompletableFuture<Chunk> getChunkAt(int x, int y, int z) {
        return getChunkAt(new ChunkLocation(x, y, z));
    }

    @NotNull
    CompletableFuture<Chunk> getChunkAt(ChunkLocation location);

    void unloadChunk(@NotNull Chunk chunk);

    void unloadChunks(@NotNull List<Chunk> chunk);

    void loadChunk(@NotNull Chunk chunk);

    default boolean isChunkLoaded(int x, int y, int z) {
        return isChunkLoaded(new ChunkLocation(x, y, z));
    }

    boolean isChunkLoaded(@NotNull ChunkLocation location);

    @NotNull
    Chunk[] getLoadedChunks();
}
