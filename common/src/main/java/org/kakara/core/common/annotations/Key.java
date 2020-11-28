package org.kakara.core.common.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * This allows you to add a unique identifier to many Kakara types which is used to generate a NameKey.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Key {
    /**
     * @return the unique identifier.
     */
    String value();
}
