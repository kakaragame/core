package org.kakara.core.resources;

import org.kakara.core.mod.Mod;

public interface ResourceManager {

    void registerResource(String path, ResourceType resourceType, Mod mod);

    Resource getResource(String path, Mod mod);

}
