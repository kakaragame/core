package org.kakara.core.common.resources;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kakara.core.common.mod.Mod;

import java.io.File;
import java.util.Optional;
import java.util.Set;
import java.util.jar.JarFile;
//~/.kakara/resources/mods/{mod_name}/{resource_type}/path
//~/.kakara/resources/mods/{mod_name}/texture/{resolution}/path
//jar paths.
// resources/{resource_type}/path
// resources/texture/{resolution}/path

/**
 * The ResourceManager handles all the resources for the Environment or Game.
 * ResourceManager has set rules on locating and saving the files.
 *
 * @since 1.0
 */
public interface ResourceManager {
    /**
     * This returns a set of all Loaded Textures
     *
     * @return all loaded textures
     * @see Texture
     * @since 1.0
     */
    Set<Texture> getAllTextures();

    /**
     * Register a new Resource.
     * <p>
     * No need to call this yourself. For more info {@link org.kakara.core.common.mod.AbstractModManager#loadResources(Mod, JarFile)}
     *
     * @param path         path within the jar. Excluding ResourceType and the BASE_PATH
     * @param resourceType the ResourceType the ResourceType
     * @param mod          the mod that has this resource
     * @since 1.0
     */
    void registerResource(@NotNull String path, @NotNull ResourceType resourceType, @NotNull Mod mod);

    /**
     * Register a new Resource.
     * <p>
     * No need to call this yourself. For more info {@link org.kakara.core.common.mod.AbstractModManager#loadResources(Mod, JarFile)}
     *
     * @param path       path within the jar. Excluding ResourceType and the BASE_PATH
     * @param resolution Unlike other resources textures have Resolutions.
     * @param mod        the mod that has this resource
     * @since 1.0
     */
    void registerTexture(@NotNull String path, @NotNull TextureResolution resolution, @NotNull Mod mod);

    /**
     * Get the resource for the file
     *
     * @param path         path within the jar. Excluding ResourceType and the BASE_PATH
     * @param resourceType the ResourceType the ResourceType
     * @param mod          the mod that has this resource
     * @return the resource. Null if not found
     * @since 1.0
     */
    @Nullable Resource getResource(String path, ResourceType resourceType, Mod mod);

    /**
     * Get the resource for the file
     *
     * @param path       path within the jar. Excluding ResourceType and the BASE_PATH
     * @param resolution Unlike other resources textures have Resolutions.
     * @param mod        the mod that has this resource
     * @return the resource. Null if not found
     * @since 1.0
     */
    Resource getTexture(String path, TextureResolution resolution, Mod mod);

    /**
     * Get the texture for the file.
     * Will contain all the different resolutions.
     *
     * @param path path within the jar. Excluding ResourceType and the BASE_PATH
     * @param mod  the mod that has this resource
     * @return the resolution.
     * @since 1.0
     */
    Optional<Texture> getTexture(String path, Mod mod);

    /**
     * Initialize the ResourceManager.
     * *Internal Use Only*
     *
     * @param baseLocation base location
     * @since 1.0
     */
    void load(File baseLocation);

}
