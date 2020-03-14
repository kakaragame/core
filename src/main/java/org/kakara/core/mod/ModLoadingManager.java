package org.kakara.core.mod;

import java.lang.reflect.Method;

public interface ModLoadingManager extends LoadStage {

    <T extends LoadStage> void registerLoadStage(T stage);

    void loadStage(LoadStage loadStage, Mod mod);
}
