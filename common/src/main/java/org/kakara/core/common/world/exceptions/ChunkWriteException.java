package org.kakara.core.common.world.exceptions;


import org.kakara.core.common.world.ChunkLocation;

import java.io.File;
import java.io.IOException;

public class ChunkWriteException extends IOException {
    private static final String MESSAGE = "Unable to write chunk: %s inside file %s";
    private final ChunkLocation chunkLocation;
    private final File file;


    public ChunkWriteException(ChunkLocation chunkLocation, File file) {
        super(String.format(MESSAGE, chunkLocation.toSimpleString(), file.getAbsolutePath()));
        this.chunkLocation = chunkLocation;
        this.file = file;
    }

    public ChunkWriteException(ChunkLocation chunkLocation, File file, Throwable cause) {
        super(String.format(MESSAGE, chunkLocation.toSimpleString(), file.getAbsolutePath()), cause);
        this.chunkLocation = chunkLocation;
        this.file = file;
    }

    public ChunkLocation getChunkLocation() {
        return chunkLocation;
    }

    public File getFile() {
        return file;
    }
}
