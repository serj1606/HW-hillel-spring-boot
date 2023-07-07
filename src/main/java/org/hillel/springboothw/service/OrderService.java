package org.hillel.springboothw.service;


import java.util.List;
import org.hillel.springboothw.model.Order;

public interface OrderService {
  public List<Order> getAllOrders();

  public Order saveOrder(Order order);

  public Order getOrder(int id);
}