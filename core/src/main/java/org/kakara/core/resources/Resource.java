package org.kakara.core.resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class Resource {
    private File file;
    private String localPath;
    private Set<String> properties = new HashSet<>();

    public Resource(File file, String localPath) {
        this.file = file;
        this.localPath = localPath;
    }

    public void addProperty(String property) {
        properties.add(property);
    }

    public Set<String> getProperties() {
        return properties;
    }

    public String getLocalPath() {
        return localPath;
    }

    public URL getURL() {
        try {
            return file.toURI().toURL();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    public File getFile() {
        return file;
    }
}
