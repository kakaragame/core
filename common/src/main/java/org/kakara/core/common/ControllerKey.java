package org.kakara.core.common;


import org.kakara.core.common.mod.Mod;

import java.util.Objects;

/**
 * This is a object version of the MOD:KEY system.
 * All Values must be uppercase
 */
public class ControllerKey {
    /**
     * Controller is the Controller meaning the Mod or Kakara. What controls the system.
     */
    private final String controller;
    /**
     * Key meaning the key to the specific item or value within the Contorller
     */
    private final String key;
    /**
     * Value being the Combined Version
     * This is only a variable for faster execution
     * use ControllerKey#toString for access
     */
    private String value;

    /**
     * Constructor for Controller Key.
     * <p>
     * * This will not make the values UPPERCASE this is assumed *
     *
     * @param controller controller uppercase
     * @param key        key upper case
     */
    public ControllerKey(String controller, String key) {
        this.controller = controller;
        this.key = key;
    }

    public ControllerKey(Mod mod, String key) {
        this(mod.getUppercaseName(), key.toUpperCase());
    }

    /**
     * Constructor for the ControllerKey
     * This will parse the ControllerKey from the format CONTROLLER:KEY
     *
     * @param asString the string
     */
    public ControllerKey(String asString) {
        String[] split = asString.toUpperCase().split(":");
        if (split.length != 2) throw new IllegalArgumentException("Must follow CONTROLLER:KEY");
        controller = split[0];
        key = split[1];
        value = asString;
    }

    /**
     * The Controller for the system
     *
     * @return the controller
     */
    public String getController() {
        return controller;
    }

    /**
     * The Key within the Controller
     *
     * @return the key within the controller
     */
    public String getKey() {
        return key;
    }

    /**
     * Creates a ControllerKey ensuring values are UpperCase
     * Calling toUpperCase is slow and we have to create ControllerKeys within the game a lot. So we needed the constructor to ignore case because we know what we are doing
     *
     * @param controller the controller
     * @param key        the key
     * @return ControllerKey with correct casing
     */
    public static ControllerKey create(String controller, String key) {
        return new ControllerKey(controller.toUpperCase(), key.toUpperCase());
    }

    //OVERIDE METHODS
    @Override
    public String toString() {
        if (value == null) value = String.format("%s:%s", controller, key);
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ControllerKey that = (ControllerKey) o;
        return that.toString().equals(toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(controller, key);
    }
}
