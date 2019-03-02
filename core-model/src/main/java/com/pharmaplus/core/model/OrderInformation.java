package com.pharmaplus.core.model;

import javax.money.MonetaryAmount;
import java.time.ZonedDateTime;
import java.util.List;

import static java.util.Objects.requireNonNull;

public final class OrderInformation {
    private final List<Batch> batches;
    private final Location from;
    private final Location destination;
    private final ZonedDateTime submittedDate;
    private final ZonedDateTime shippingDate;

    public OrderInformation(List<Batch> batches, Location from, Location destination, ZonedDateTime submittedDate, ZonedDateTime shippingDate) {
        this.batches = requireNonNull(batches);
        this.from = requireNonNull(from);
        this.destination = requireNonNull(destination);
        this.submittedDate = requireNonNull(submittedDate);
        this.shippingDate = requireNonNull(shippingDate);
    }

    public List<Batch> batches() {
        return batches;
    }

    public Location from() {
        return from;
    }

    public Location destination() {
        return destination;
    }

    public ZonedDateTime submittedDate() {
        return submittedDate;
    }

    public ZonedDateTime shippingDate() {
        return shippingDate;
    }

    public MonetaryAmount totalCost() {
        return batches.stream()
                .map(Batch::price)
                .reduce(MonetaryAmount::add)
                .orElseThrow(() -> new IllegalStateException("Can not calculate total amount for this order"));
    }
}
