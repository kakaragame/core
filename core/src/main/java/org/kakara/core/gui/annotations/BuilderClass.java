package org.kakara.core.gui.annotations;

import org.kakara.core.gui.InventoryBuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use this annotation on your Inventory to point to its builder
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface BuilderClass {
    /**
     * Set this value to the InventoryBuilder class for your Inventory
     *
     * @return the Inventory's Builder Class
     */
    Class<? extends InventoryBuilder<?>> value();
}
