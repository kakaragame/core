package org.kakara.core.world;

import org.kakara.core.mod.Mod;

public interface ChunkGenerator {
    class ChunkFormat {
        private int width, worldHeight, length;

        public ChunkFormat(int width, int worldHeight, int length) {
            this.width = width;
            this.worldHeight = worldHeight;
            this.length = length;
        }

        public int getWidth() {
            return width;
        }

        public int getWorldHeight() {
            return worldHeight;
        }

        public int getLength() {
            return length;
        }
    }

    Mod getMod();

    String getName();

    ChunkFormat getChunkFormat();

    ChunkBase generateChunk(int seed, ChunkBase chunkBase);
}
