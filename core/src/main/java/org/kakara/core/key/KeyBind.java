package org.kakara.core.key;

import java.util.List;

/**
 * this represent the keys used.
 */
public class KeyBind {
    private List<Key> defaultKeys;
    private List<Key> currentKeys;

    public KeyBind(List<Key> defaultKeys, List<Key> currentKeys) {
        this.defaultKeys = defaultKeys;
        this.currentKeys = currentKeys;
    }

    public KeyBind(List<Key> defaultKeys) {
        this.defaultKeys = defaultKeys;
    }

    public List<Key> getDefaultKeys() {
        return defaultKeys;
    }

    public void setDefaultKeys(List<Key> defaultKeys) {
        this.defaultKeys = defaultKeys;
    }

    public List<Key> getCurrentKeys() {
        return currentKeys;
    }

    public void setCurrentKeys(List<Key> currentKeys) {
        this.currentKeys = currentKeys;
    }
}
