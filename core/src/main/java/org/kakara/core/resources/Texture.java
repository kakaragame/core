package org.kakara.core.resources;

import org.kakara.core.Kakara;
import org.kakara.core.mod.Mod;

import java.util.HashMap;
import java.util.Map;

public class Texture {
    private Map<TextureResolution, Resource> resolutionResourceMap = new HashMap<>();
    private String path;
    private Mod mod;
    private TextureResolution defaultResolution = TextureResolution._16;

    public Texture(String path, Mod mod) {
        this.path = path;
        this.mod = mod;
    }

    public Texture(String path, Mod mod, TextureResolution defaultResolution) {
        this.path = path;
        this.mod = mod;
        this.defaultResolution = defaultResolution;
    }

    public void addResolution(TextureResolution textureResolution, Resource resource) {
        resolutionResourceMap.putIfAbsent(textureResolution, resource);
        recalibrateDefaultResolution();
    }

    private void recalibrateDefaultResolution() {
        if (resolutionResourceMap.size() == 0) {
            Kakara.LOGGER.warn("No Textures are available for " + path);
            return;
        }
        try {
            if (!resolutionResourceMap.containsKey(defaultResolution)) {
                if (defaultResolution == TextureResolution._4) {
                    defaultResolution = TextureResolution._2048;
                } else {
                    defaultResolution = TextureResolution.get(defaultResolution.getResolution() / 2);
                }
                recalibrateDefaultResolution();
            }
        } catch (StackOverflowError e) {
            Kakara.LOGGER.error("Unable to locate any available texture for " + path, e);
        }
    }

    public Resource get() {
        return getByResolution(defaultResolution);
    }

    public void setDefaultResolution(TextureResolution defaultResolution) {
        this.defaultResolution = defaultResolution;
        recalibrateDefaultResolution();
    }

    public Resource getByResolution(TextureResolution resolution) {
        if (resolutionResourceMap.containsKey(resolution)) return resolutionResourceMap.get(resolution);
        return get();
    }
}
