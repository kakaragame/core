package org.kakara.core.resources;

import org.kakara.core.KakaraCore;
import org.kakara.core.mod.Mod;

//~/.kakara/resources/mods/{mod_name}/{resource_type}/path
//~/.kakara/resources/mods/{mod_name}/texture/{resolution}/path
//jar paths.
// resources/{resource_type}/path
// resources/texture/{resolution}/path
public interface ResourceManager {

    void registerResource(String path, ResourceType resourceType, Mod mod);

    void registerTexture(String path, int textureResolution, Mod mod);

    Resource getResource(String path, ResourceType resourceType, Mod mod);

    Resource getTexture(String path, ResourceType resourceType, Mod mod);

    void load(KakaraCore kakaraCore);

}
