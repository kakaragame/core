package org.kakara.core.service;

import org.kakara.core.ControllerKey;
import org.kakara.core.Identifiable;

public interface Service extends Identifiable {
    ControllerKey getImplementationNameKey();

    String getImplementationName();

    int getImplementationId();
}
