package org.kakara.core.test;

import org.kakara.core.KakaraCore;
import org.kakara.core.mod.Mod;
import org.kakara.core.resources.Resource;
import org.kakara.core.resources.ResourceManager;
import org.kakara.core.resources.ResourceType;

public class TestResourceManager implements ResourceManager {
    private KakaraCore kakaraCore;

    @Override
    public void registerResource(String path, ResourceType resourceType, Mod mod) {

    }

    @Override
    public void registerTexture(String path, int textureResolution, Mod mod) {

    }

    @Override
    public Resource getResource(String path, ResourceType resourceType, Mod mod) {
        return null;
    }

    @Override
    public Resource getTexture(String path, ResourceType resourceType, Mod mod) {
        return null;
    }

    @Override
    public void load(KakaraCore kakaraCore) {
        this.kakaraCore = kakaraCore;
    }
}
