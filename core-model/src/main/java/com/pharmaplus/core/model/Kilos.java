package com.pharmaplus.core.model;

import static java.util.Objects.requireNonNull;

public final class Kilos {
    private final Long numberOfKilos;

    private Kilos(Long numberOfKilos) {
        this.numberOfKilos = requireNonNull(numberOfKilos);
    }

    public static Kilos of(Long numberOfKilos) {
        return new Kilos(numberOfKilos);
    }
}
