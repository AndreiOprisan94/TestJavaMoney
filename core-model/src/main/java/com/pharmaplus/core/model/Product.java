package com.pharmaplus.core.model;

import static java.util.Objects.requireNonNull;

public final class Product {
    private final String id;
    private final String description;

    public Product(String id, String description) {
        this.id = requireNonNull(id);
        this.description = requireNonNull(description);
    }

    public String id() {
        return id;
    }

    public String description() {
        return description;
    }


}
