package com.zephyrus.orderservice.repositories;

import com.zephyrus.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
