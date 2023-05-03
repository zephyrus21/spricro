package com.zephyrus.orderservice.controllers;

import com.zephyrus.orderservice.dto.OrderRequest;
import com.zephyrus.orderservice.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
  private final OrderService orderService;

  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
  public String createOrder(@RequestBody OrderRequest orderRequest) {
    orderService.placeOrder(orderRequest);
    return "Order placed successfully";
  }
}
