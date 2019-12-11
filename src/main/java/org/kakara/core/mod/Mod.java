package org.kakara.core.mod;

import org.kakara.core.KakaraCore;

public interface Mod {


    String getName();

    String getVersion();

    String[] getAuthors();

    String getDescription();

    ModType getModType();





    KakaraCore getKakaraCore();
}
