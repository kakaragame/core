package org.kakara.core.resources;

public enum TextureResolution {
    _4(4),
    _8(8),
    _16(16),
    _32(32),
    _64(64),
    _128(128),
    _256(256),
    _512(512),
    _1024(1024),
    /**
     * lttstore.com
     */
    _2048(2048);

    private int resolution;

    TextureResolution(int resolution) {
        this.resolution = resolution;
    }

    public int getResolution() {
        return resolution;
    }

    public static TextureResolution get(int resolution) {
        for (TextureResolution r : values()) {
            if (r.resolution == resolution) return r;
        }
        return null;
    }
}
