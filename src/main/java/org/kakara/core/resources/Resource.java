package org.kakara.core.resources;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Resource {
    private File file;

    public Resource(File file) {
        this.file = file;
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
