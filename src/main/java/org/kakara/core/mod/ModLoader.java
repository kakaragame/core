package org.kakara.core.mod;

import org.kakara.core.exceptions.IllegalModException;

import java.io.File;
import java.io.IOException;

public interface ModLoader {

    Mod load(File file) throws IOException, IllegalModException;

    void unload(Mod mod) throws IOException;
}
