package com.filmage.bagages.filmage.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public interface MachineState {
    void available();
    void unavailable();
    void inuse();

    boolean isAvailable();
}
