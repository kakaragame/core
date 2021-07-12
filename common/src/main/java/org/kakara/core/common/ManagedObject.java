package org.kakara.core.common;

/**
 * An objected that has a status and can be loaded/unloaded.
 */
public interface ManagedObject {
    /**
     * Get the status of the ManagedObject.
     *
     * @return The status of the ManagedObject.
     */
    Status getStatus();

    /**
     * Get the percent for loading or unloading.
     *
     * <p>This is mainly used for graphical indications.</p>
     *
     * @return The percent as an int between 0-100.
     */
    int getPercent();
}
