package org.kakara.core.auth;

import java.util.UUID;

public interface AuthAPI {
    boolean validToken(String token, UUID uuid);
}
