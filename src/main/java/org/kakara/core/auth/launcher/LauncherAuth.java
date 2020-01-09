package org.kakara.core.auth.launcher;

import org.kakara.core.auth.AuthAccount;

public interface LauncherAuth {

    AuthAccount login(String username, String password);

}
