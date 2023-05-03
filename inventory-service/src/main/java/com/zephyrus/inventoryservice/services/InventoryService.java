package com.zephyrus.inventoryservice.services;

import com.zephyrus.inventoryservice.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {
  private final InventoryRepository inventoryrepository;

  @Transactional(readOnly = true)
  public boolean isInStock(String skuCode) {
    return inventoryrepository.findBySkuCode(skuCode).isPresent();
  }
}
