package org.kakara.core.mod;

import org.kakara.core.exceptions.IllegalModException;

import java.io.File;
import java.io.IOException;

public interface ModLoader {

    UnModObject load(File file) throws IOException, IllegalModException;

    Mod createMod(UnModObject unModObject) throws ClassNotFoundException, IllegalModException;

    void unload(Mod mod) throws IOException;
}
