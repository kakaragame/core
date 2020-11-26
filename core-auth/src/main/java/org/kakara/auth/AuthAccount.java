package org.kakara.auth;


import java.util.List;

public interface AuthAccount {
    List<GameAccount> getGameAccounts();

    String getToken();
}
