package org.kakara.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This can be applied to a Block and decides the hardness value of the block type.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Hardness {
    /**
     * @return a floating-point used to determine how long it takes to break a block.
     */
    float value();
}
