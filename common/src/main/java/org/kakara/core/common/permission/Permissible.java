package org.kakara.core.common.permission;


public interface Permissible {
    PermissionSet getPermissions();

    default boolean hasPermission(String permission) {
        return getPermissions().contains(permission);
    }

    default void addPermission(String permission) {
        getPermissions().add(permission);
    }

    default void removePermission(String permission) {
        getPermissions().remove(permission);
    }
}
