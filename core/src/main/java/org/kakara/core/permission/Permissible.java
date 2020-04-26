package org.kakara.core.permission;

public interface Permissible {


    boolean hasPermission(String permission);

    void addPermission(String permission);

    void removePermission(String permission);
}
