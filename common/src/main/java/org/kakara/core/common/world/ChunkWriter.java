package org.kakara.core.common.world;


import org.kakara.core.common.world.exceptions.ChunkLoadException;
import org.kakara.core.common.world.exceptions.ChunkWriteException;

import java.util.List;

public interface ChunkWriter {
    /**
     * gets a single chunk
     *
     * @param chunkLocation the location
     * @return the single chunk null if not found
     * @throws ChunkLoadException thrown when chunk fails to read.
     */
    ChunkContent getChunkByLocation(ChunkLocation chunkLocation) throws ChunkLoadException;

    /**
     * Gets a group of chunks. This will sort the locations so we dont have to open a file multiple times
     *
     * @param locations the locations to find
     * @return the chunks no value if not found
     * @throws ChunkLoadException thrown when chunk fails to read.
     */
    List<ChunkContent> getChunksByLocation(List<ChunkLocation> locations) throws ChunkLoadException;

    /**
     * writes a single chunk to its correct file
     *
     * @param chunk the chunk
     * @throws ChunkWriteException thrown when chunk fails to write
     */
    void writeChunk(ChunkContent chunk) throws ChunkWriteException;

    /**
     * Writes a group of chunks. This will sort the locations so we dont have to open a file multiple times
     *
     * @param chunks the chunks to save
     * @throws ChunkWriteException thrown when chunk fails to write.
     */
    void writeChunks(List<ChunkContent> chunks) throws ChunkWriteException;

    boolean supportsSingleBlockWrites();

    /**
     * writes a single block to its correct file and chunk
     *
     * @param block the chunk
     * @throws ChunkWriteException thrown when block fails to write
     */
    void writeBlock(GameBlock block) throws ChunkWriteException;

    /**
     * Writes a group of chunks. This will sort the locations so we don't have to open a file multiple times
     *
     * @param blocks the blocks to save
     * @throws ChunkWriteException thrown when blocks fails to write.
     */
    void writeBlock(List<GameBlock> blocks) throws ChunkWriteException;

}
