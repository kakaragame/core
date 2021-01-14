package org.kakara.core.common.mod;


import org.kakara.core.common.exceptions.IllegalModException;

import java.io.File;
import java.io.IOException;

public interface ModLoader {

    UnModObject load(File file) throws IOException, IllegalModException;

    Mod createMod(UnModObject unModObject) throws ClassNotFoundException, IllegalModException;

    void unload(Mod mod) throws IOException;

    Class<?> getClassByName(String name);
}
