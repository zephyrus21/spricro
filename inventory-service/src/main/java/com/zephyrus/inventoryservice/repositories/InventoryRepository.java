package com.zephyrus.inventoryservice.repositories;

import com.zephyrus.inventoryservice.models.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
  List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
