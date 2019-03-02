package com.pharmaplus.orders.service.app;

import com.pharmaplus.orders.service.repository.DummyRepository;
import spark.Spark;

public final class MainApp {
    private MainApp() {

    }

    public static void main(String[] args) {
        final var repository = new DummyRepository();
        final var ordersRouteHandler = new OrdersRouteHandler(repository);

        Spark.port(8081);
        Spark.get("/orders/:id", "application/json", ordersRouteHandler);
    }
}
