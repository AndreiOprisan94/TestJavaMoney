package com.pharmaplus.core.model;

import static java.util.Objects.requireNonNull;

public final class Order {
    private final String id;
    private final OrderInformation orderInformation;

    public Order(String id, OrderInformation orderInformation) {
        this.id = requireNonNull(id);
        this.orderInformation = requireNonNull(orderInformation);
    }

    public String id() {
        return id;
    }

    public OrderInformation orderInformation() {
        return orderInformation;
    }
}
