package org.kakara.core.resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Resource {
    private File file;
    private String localPath;

    public Resource(File file, String localPath) {
        this.file = file;
        this.localPath = localPath;
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
