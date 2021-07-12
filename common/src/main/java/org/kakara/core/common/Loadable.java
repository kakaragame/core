package org.kakara.core.common;

/**
 * An objected that is loadable.
 */
public interface Loadable {
    /**
     * Get the status of the object.
     *
     * @return The status of the object.
     */
    Status getStatus();

    /**
     * Get the percent for loading or unloading.
     *
     * <p>This is mainly used for graphical indications.</p>
     *
     * <p>When an object is unloaded or loaded percent will be 100.</p>
     *
     * @return The percent as an int between 0-100.
     */
    int getPercent();
}
