package org.kakara.core.mod;

public interface LoadStage {
    default String getName() {
        return getClass().getSimpleName();
    }

    Class<?> getStageClass();
}
