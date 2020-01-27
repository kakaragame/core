package org.kakara.core.world;

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

    ChunkFormat getChunkFormat();

    ChunkBase generateChunk(ChunkBase chunkBase);
}