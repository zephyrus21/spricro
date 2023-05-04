package com.zephyrus.orderservice.services;

import com.zephyrus.orderservice.dto.InventoryResponse;
import com.zephyrus.orderservice.dto.OrderLineItemsDto;
import com.zephyrus.orderservice.dto.OrderRequest;
import com.zephyrus.orderservice.models.Order;
import com.zephyrus.orderservice.models.OrderLineItems;
import com.zephyrus.orderservice.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {
  private final OrderRepository orderRepository;
  private final WebClient webClient;

  public void placeOrder(OrderRequest orderRequest) {
    Order order = new Order();
    order.setOrderNumber(UUID.randomUUID().toString());

    List<OrderLineItems> orderLineItems = orderRequest
        .getOrderLineItemsDtoList()
        .stream()
        .map(this::mapToDto)
        .toList();

    order.setOrderLineItemsList(orderLineItems);

    List<String> skuCodes = order.getOrderLineItemsList().stream()
        .map(OrderLineItems::getSkuCode)
        .toList();

    // Call to inventory service to check if the items are in stock then place the order
    InventoryResponse[] inventoryResponseArray = webClient.get()
        .uri("http://localhost:8082/api/inventory", uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
        .retrieve()
        .bodyToMono(InventoryResponse[].class)
        .block();
    
    boolean allProductsInStock = Arrays.stream(inventoryResponseArray)
        .allMatch(InventoryResponse::isInStock);

    if (allProductsInStock)
      orderRepository.save(order);
    else
      throw new IllegalArgumentException("Item out of stock");
  }

  private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
    OrderLineItems orderLineItems = new OrderLineItems();
    orderLineItems.setPrice(orderLineItemsDto.getPrice());
    orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
    orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
    return orderLineItems;
  }
}
