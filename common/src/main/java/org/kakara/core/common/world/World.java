package org.kakara.core.common.world;

import org.jetbrains.annotations.NotNull;
import org.kakara.core.common.ManagedObject;
import org.kakara.core.common.Serverable;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

/**
 * A object representation of a World.
 */
public interface World extends ManagedObject, Serverable {
    /**
     * Get loaded chunks for the world.
     *
     * @return the loaded chunks.
     */
    @NotNull
    Set<Chunk> getChunks();

    /**
     * Get World UUID
     *
     * @return world UUID.
     */
    @NotNull
    UUID getUUID();

    /**
     * World Name
     *
     * @return world name.
     */
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
