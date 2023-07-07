package com.springBoot.service;


import com.springBoot.model.Order;
import java.util.List;

public interface OrderService {
  public List<Order> getAllOrders();

  public Order saveOrder(Order order);

  public Order getOrder(int id);
}