package com.pharmaplus.orders.service.app;

import com.pharmaplus.core.repository.OrderRepository;
import spark.Request;
import spark.Response;
import spark.Route;

import static java.util.Objects.requireNonNull;

public final class OrdersRouteHandler implements Route {
    private final OrderRepository repository;

    OrdersRouteHandler(OrderRepository repository) {
        this.repository = requireNonNull(repository);
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        final var orderId = request.params(":id");

        return repository.findById(orderId)
                .orElseThrow(IllegalArgumentException::new);

    }
}
