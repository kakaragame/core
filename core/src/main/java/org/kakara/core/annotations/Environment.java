package org.kakara.core.annotations;

import org.kakara.core.EnvType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This will state that this method/class only works on a specific GameType.
 * Not all classes or methods are compatible with this, check the classes documentation.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Environment {
    /**
     * @return the GameType which the applied-to method supports.
     * If this value is null, the applied-to method will work on all game types.
     */
    EnvType value();
}
