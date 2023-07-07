package org.hillel.springboothw.controller;

import org.hillel.springboothw.model.Order;
import org.hillel.springboothw.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
