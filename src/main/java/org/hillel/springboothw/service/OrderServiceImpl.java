package org.hillel.springboothw.service;

import org.hillel.springboothw.exeption.NoSuchOrderException;
import org.hillel.springboothw.model.Order;
import org.hillel.springboothw.model.Product;
import org.hillel.springboothw.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
