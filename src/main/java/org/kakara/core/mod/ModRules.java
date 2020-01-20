package org.kakara.core.mod;

public interface ModRules {

    String getName();

    String getVersion();

    String[] getAuthors();

    String getDescription();

    ModType getModType();
}
