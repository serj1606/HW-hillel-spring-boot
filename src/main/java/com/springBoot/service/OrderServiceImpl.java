package com.springBoot.service;

import com.springBoot.exeption.NoSuchOrderException;
import com.springBoot.model.Order;
import com.springBoot.model.Product;
import com.springBoot.repository.OrderRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private OrderRepository orderRepository;

  @Override
  public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }

  @Override
  public Order saveOrder(Order order) {

    order.setDate(LocalDateTime.now());
    order.setCost(getOrderCost(order.getProducts()));

    orderRepository.save(order);
    return order;
  }

  private BigDecimal getOrderCost(List<Product> productList) {
    BigDecimal totalCost = BigDecimal.ZERO;
    for (Product product : productList) {
      totalCost = totalCost.add(product.getCost());
    }
    return totalCost;
  }

  @Override
  public Order getOrder(int id) {
    Optional<Order> optional = orderRepository.findById(id);
    if (optional.isEmpty()) {
      throw new NoSuchOrderException("There is no order with ID = " + id + " in Database.");
    }
    return optional.get();
  }
}
