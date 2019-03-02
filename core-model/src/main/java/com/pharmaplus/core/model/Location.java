package com.pharmaplus.core.model;

import static java.util.Objects.requireNonNull;

public final class Location {
    private final String country;
    private final String region;
    private final String address;
    private final String zipCode;

    public Location(String country, String region, String address, String zipCode) {
        this.country = requireNonNull(country);
        this.region = requireNonNull(region);
        this.address = requireNonNull(address);
        this.zipCode = requireNonNull(zipCode);
    }

    public String country() {
        return country;
    }

    public String region() {
        return region;
    }

    public String address() {
        return address;
    }

    public String zipCode() {
        return zipCode;
    }
}
