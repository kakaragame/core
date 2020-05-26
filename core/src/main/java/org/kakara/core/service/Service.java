package org.kakara.core.service;

import org.kakara.core.Identifiable;
import org.kakara.core.NameKey;

public interface Service extends Identifiable {
    NameKey getImplementationNameKey();

    String getImplementationName();

    int getImplementationId();
}
