package org.kakara.core.common.resources;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * A Object representation of a resource
 *
 * @see ResourceManager
 */
public class Resource {
    private final File file;
    private final String localPath;
    private final Set<String> properties = new HashSet<>();

    /**
     * Basic constructor for ResourceManager
     *
     * @param file      the file
     * @param localPath local path.
     */
    public Resource(@NotNull File file, @NotNull String localPath) {
        this.file = file;
        this.localPath = localPath;
    }

    /**
     * Add a property to the resource
     *
     * @param property the property
     */
    public void addProperty(@NotNull String property) {
        properties.add(property);
    }

    /**
     * The properties for the resource
     *
     * @return the properties
     */
    public @NotNull Set<String> getProperties() {
        return properties;
    }

    /**
     * The local path.
     * <p>
     * LocalPath is the internal jar path
     *
     * @return the local path
     */
    public @NotNull String getLocalPath() {
        return localPath;
    }

    /**
     * The URL of the resource
     *
     * @return URL null if MalformedURLException is thrown
     */
    public @Nullable URL getURL() {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    /**
     * The file for the resource
     *
     * @return the file
     */
    public @NotNull File getFile() {
        return file;
    }
}
