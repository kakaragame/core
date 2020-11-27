package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.ManagedObject;
import org.kakara.core.common.Serverable;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

public interface World extends ManagedObject, Serverable {
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
