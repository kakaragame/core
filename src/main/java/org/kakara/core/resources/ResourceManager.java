package org.kakara.core.resources;

import org.kakara.core.mod.Mod;
//~/.kakara/resources/mods/{mod_name}/{resource_type}/path
public interface ResourceManager {

    void registerResource(String path, ResourceType resourceType, Mod mod);

    Resource getResource(String path, ResourceType resourceType, Mod mod);

}
