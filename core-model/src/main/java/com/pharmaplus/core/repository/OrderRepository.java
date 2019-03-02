package com.pharmaplus.core.repository;

import com.pharmaplus.core.model.Order;
import com.pharmaplus.core.model.OrderInformation;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {
    Optional<Order> findById(String id);
    List<Order> getAll();
    Order createOrder(OrderInformation information);
    List<Order> createAll(List<OrderInformation> orderInformationList);
}
