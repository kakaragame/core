package org.kakara.core.world;

import org.kakara.core.world.Chunk;
import org.kakara.core.world.ChunkBase;
import org.kakara.core.world.ChunkContent;
import org.kakara.core.world.ChunkLocation;

import java.util.List;

public interface ChunkWriter {
    /**
     * gets a single chunk
     *
     * @param chunkLocation the location
     * @return the single chunk null if not found
     */
    ChunkContent getChunkByLocation(ChunkLocation chunkLocation);

    /**
     * Gets a group of chunks. This will sort the locations so we dont have to open a file multiple times
     *
     * @param locations the locations to find
     * @return the chunks no value if not found
     */
    List<ChunkContent> getChunksByLocation(List<ChunkLocation> locations);

    /**
     * writes a single chunk to its correct file
     *
     * @param chunk the chunk
     */
    void writeChunk(ChunkContent chunk);

    /**
     * Writes a group of chunks. This will sort the locations so we dont have to open a file multiple times
     *
     * @param chunks the chunks to save
     */
    void writeChunks(List<ChunkContent> chunks);

}
