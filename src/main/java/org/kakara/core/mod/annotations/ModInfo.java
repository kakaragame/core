package org.kakara.core.mod.annotations;

import org.kakara.core.mod.ModType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ModInfo {
    String name();

    String version();

    String[] authors() default "";

    String description() default "";

    ModType modType();
}
