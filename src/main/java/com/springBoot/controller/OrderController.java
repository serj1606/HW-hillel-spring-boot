package com.springBoot.controller;

import com.springBoot.model.Order;
import com.springBoot.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;

  @GetMapping
  public List<Order> showAllOrders() {
    return orderService.getAllOrders();
  }

  @GetMapping("/{id}")
  public Order showOrderById(@PathVariable int id) {
    return orderService.getOrder(id);
  }
}
