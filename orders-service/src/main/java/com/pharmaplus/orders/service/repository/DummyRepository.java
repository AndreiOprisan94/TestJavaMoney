package com.pharmaplus.orders.service.repository;

import com.pharmaplus.core.model.Batch;
import com.pharmaplus.core.model.Kilos;
import com.pharmaplus.core.model.Location;
import com.pharmaplus.core.model.Order;
import com.pharmaplus.core.model.OrderInformation;
import com.pharmaplus.core.model.Product;
import com.pharmaplus.core.repository.OrderRepository;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public final class DummyRepository implements OrderRepository {
    private final Order dummyOrder;
    private final OrderInformation hardcodedOrderInformation;
    private final List<Order> orders = new ArrayList<>();

    public DummyRepository() {
        final var product = new Product("Product1", "Some dummy product");

        final CurrencyUnit usd = Monetary.getCurrency("USD");
        final var price = Monetary.getDefaultAmountFactory().setCurrency(usd).setNumber(500).create();

        final var batch = new Batch("Batch1", List.of(product), price, Kilos.of(10000L));

        final var locationFrom = new Location("Germany", "Weistel", "Firsten street, 84", "24394");
        final var locationTo = new Location("Romania", "Bucharest", "Strada General Petru, 89", "12423");
        final var submittedDate = ZonedDateTime.of(LocalDateTime.of(2019, 1, 2, 12, 23), ZoneId.of("Europe/Berlin"));
        final var shippingDate = ZonedDateTime.of(LocalDateTime.of(2019, 1, 2, 12, 23), ZoneId.of("Europe/Bucharest"));

        this.hardcodedOrderInformation = new OrderInformation(List.of(batch), locationFrom, locationTo, submittedDate, shippingDate);

        this.dummyOrder = new Order("Order1", this.hardcodedOrderInformation);
    }

    @Override
    public Optional<Order> findById(String id) {
        return Optional.of(dummyOrder);
    }

    @Override
    public List<Order> getAll() {
        return List.of(dummyOrder);
    }

    @Override
    public Order createOrder(OrderInformation information) {
        final var newOrderId = UUID.randomUUID().toString();
        final var order = new Order(newOrderId, information);
        this.orders.add(order);

        return order;
    }

    @Override
    public List<Order> createAll(List<OrderInformation> orderInformationList) {
        return orderInformationList.stream()
                .map(this::createOrder)
                .collect(Collectors.toList());
    }
}
