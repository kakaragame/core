package org.kakara.core.test;

import org.kakara.core.GameInstance;
import org.kakara.core.mod.Mod;
import org.kakara.core.resources.*;

import java.util.Optional;
import java.util.Set;

public class TestResourceManager implements ResourceManager {
    private GameInstance GameInstance;


    @Override
    public Set<Texture> getAllTextures() {
        return null;
    }

    @Override
    public void registerResource(String path, ResourceType resourceType, Mod mod) {

    }

    @Override
    public void registerTexture(String path, TextureResolution resolution, Mod mod) {

    }

    @Override
    public Resource getResource(String path, ResourceType resourceType, Mod mod) {
        return null;
    }

    @Override
    public Resource getTexture(String path, TextureResolution resolution, Mod mod) {
        return null;
    }

    @Override
    public Optional<Texture> getTexture(String path, Mod mod) {
        return Optional.empty();
    }

    @Override
    public void load(org.kakara.core.GameInstance kakaraCore) {

    }
}
