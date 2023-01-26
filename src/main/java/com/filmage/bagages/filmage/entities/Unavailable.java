package com.filmage.bagages.filmage.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Unavailable implements MachineState{
    /**
     *
     */
    @Override
    public void available() {

    }

    /**
     *
     */
    @Override
    public void unavailable() {

    }

    /**
     *
     */
    @Override
    public void inuse() {

    }

    /**
     * @return
     */
    @Override
    public boolean isAvailable() {
        return false;
    }
}
