package org.kakara.core.resources;

import org.kakara.core.GameInstance;
import org.kakara.core.mod.Mod;

import java.util.List;

//~/.kakara/resources/mods/{mod_name}/{resource_type}/path
//~/.kakara/resources/mods/{mod_name}/texture/{resolution}/path
//jar paths.
// resources/{resource_type}/path
// resources/texture/{resolution}/path
public interface ResourceManager {
    List<Resource> getAllTextures(TextureResolution resolution);

    void registerResource(String path, ResourceType resourceType, Mod mod);

    void registerTexture(String path, TextureResolution resolution, Mod mod);

    Resource getResource(String path, ResourceType resourceType, Mod mod);

    Resource getTexture(String path, TextureResolution resolution, Mod mod);

    void load(GameInstance kakaraCore);

}
