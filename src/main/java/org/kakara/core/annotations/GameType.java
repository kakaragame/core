package org.kakara.core.annotations;

import org.kakara.core.GameTypes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
/**
 * If null it will work on all GameTypes
 * This will state that this method/class only works on a specific GameType. Not all classes or methods are compatible with this. Check the classes documentation
 *
 */
public @interface GameType {
    GameTypes value();
}
