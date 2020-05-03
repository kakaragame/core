package org.kakara.core.annotations;

import org.kakara.core.GameTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This will state that this method/class only works on a specific GameType.
 * Not all classes or methods are compatible with this, check the classes documentation.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface GameType {
    /**
     * @return the GameType which the applied-to method supports.
     * If this value is null, the applied-to method will work on all game types.
     */
    GameTypes value();
}
