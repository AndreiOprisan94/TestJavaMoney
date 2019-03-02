package com.pharmaplus.core.model;

import static java.util.Objects.requireNonNull;

public final class Miles {
    private final Long numberOfMiles;

    private Miles(Long numberOfMiles) {
        this.numberOfMiles = requireNonNull(numberOfMiles);
    }

    public static Miles of(Long numberOfMiles) {
        return new Miles(numberOfMiles);
    }
}
