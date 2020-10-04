package org.kakara.core.mod;

/**
 * Represents a LoadStage.
 * <p>
 * implement this interface if you are creating a custom LoadStage.
 * <p>
 * You can call it by doing ModManager#loadStage(instance)
 *
 * @see ModManager
 */
public interface LoadStage {
    /**
     * The Stage Name
     *
     * @return the stage name
     */
    default String getName() {
        return getClass().getSimpleName();
    }

    /**
     * The stage class.
     * In case the stage is an interface make this return the interface class. Not the Implementation
     *
     * @return the stage class
     */
    Class<?> getStageClass();
}
