package org.kakara.core.resources;

import org.kakara.core.Kakara;
import org.kakara.core.mod.Mod;

import java.util.*;

public class Texture {
    private final Map<TextureResolution, Resource> resolutionResourceMap = new HashMap<>();
    private final String path;
    private final Mod mod;
    private TextureResolution defaultResolution = TextureResolution._16;
    private final Set<String> properties = new HashSet<>();

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

    public Resource getByResolution(TextureResolution resolution) {
        if (resolutionResourceMap.containsKey(resolution)) return resolutionResourceMap.get(resolution);
        return get();
    }

    public String getPath() {
        return path;
    }

    public Mod getMod() {
        return mod;
    }

    public void addProperty(String property) {
        properties.add(property);
    }

    public Set<String> getProperties() {
        return properties;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Texture texture = (Texture) o;
        return Objects.equals(getPath(), texture.getPath()) &&
                Objects.equals(getMod(), texture.getMod());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPath(), getMod());
    }

    public TextureResolution getDefaultResolution() {
        return defaultResolution;
    }

    public void setDefaultResolution(TextureResolution defaultResolution) {
        this.defaultResolution = defaultResolution;
        recalibrateDefaultResolution();
    }
}
