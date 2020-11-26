package org.kakara.core.game.world;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.ManagedObject;
import org.kakara.core.game.game.Block;
import org.kakara.core.game.game.ItemStack;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface World extends ManagedObject {
    @NotNull
    Set<Chunk> getChunks();

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
    default Chunk getChunkAt(int x, int y, int z) {
        return getChunkAt(new ChunkLocation(x, y, z));
    }

    @NotNull
    Chunk getChunkAt(ChunkLocation location);

    void unloadChunk(@NotNull Chunk chunk);

    void unloadChunks(@NotNull List<Chunk> chunk);

}
