package ru.aasmc.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.aasmc.orderservice.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
}