package org.kakara.core.auth;

import java.util.UUID;

public interface GameAccount {
    UUID getUUID();

    String getUsername();
}
