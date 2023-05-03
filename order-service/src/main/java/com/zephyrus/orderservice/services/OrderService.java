package com.zephyrus.orderservice.services;

import com.zephyrus.orderservice.dto.OrderLineItemsDto;
import com.zephyrus.orderservice.dto.OrderRequest;
import com.zephyrus.orderservice.models.Order;
import com.zephyrus.orderservice.models.OrderLineItems;
import com.zephyrus.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
  private final OrderRepository orderRepository;

  public void placeOrder(OrderRequest orderRequest) {
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());

    List<OrderLineItems> orderLineItems = orderRequest
        .getOrderLineItemsDtoList()
        .stream()
        .map(this::mapToDto)
        .toList();

    order.setOrderLineItemsList(orderLineItems);

    orderRepository.save(order);
  }

  private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
    OrderLineItems orderLineItems = new OrderLineItems();
    orderLineItems.setPrice(orderLineItemsDto.getPrice());
    orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
    orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
    return orderLineItems;
  }
}
