package com.pharmaplus.core.model;

import javax.money.MonetaryAmount;
import java.util.List;

import static java.util.Objects.requireNonNull;

public final class Batch {
    private final String id;
    private final List<Product> products;
    private final MonetaryAmount price;
    private final Kilos weight;

    public Batch(String id, List<Product> products, MonetaryAmount price, Kilos weight) {
        this.id = requireNonNull(id);
        this.products = requireNonNull(products);
        this.price = price;
        this.weight = requireNonNull(weight);
    }

    public String id() {
        return id;
    }

    public List<Product> products() {
        return products;
    }

    public MonetaryAmount price() {
        return price;
    }

    public Kilos weight() {
        return weight;
    }
}
