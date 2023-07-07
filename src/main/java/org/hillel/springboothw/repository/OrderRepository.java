package org.hillel.springboothw.repository;

import org.hillel.springboothw.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}