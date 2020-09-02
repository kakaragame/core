package org.kakara.core.player;

import java.util.HashSet;

public class PermissionSet extends HashSet<String> {
    /**
     * This is essentially a normal HashSet#contains except it also checks for wildcard permissions.
     * e.g. if the set contained "thing.*", and you checked for "thing.other.extra", it would return true.
     *
     * @param object the object to check the containment of
     * @return whether this set contains object
     */
    @Override
    public boolean contains(Object object) {
        if (!(object instanceof String)) return false;
        if (super.contains("*")) return true;

        String string = (String) object;
        if (super.contains(string)) return true;

        StringBuilder current = new StringBuilder();

        for (String sub : string.split("\\.")) {
            current.append(sub);

            if (sub.contains(current + ".*")) return true;

            current.append(".");
        }

        return false;
    }
}
