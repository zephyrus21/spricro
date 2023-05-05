package com.zephyrus.inventoryservice;

import com.zephyrus.inventoryservice.models.Inventory;
import com.zephyrus.inventoryservice.repositories.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {
  public static void main(String[] args) {
    SpringApplication.run(InventoryServiceApplication.class, args);
  }

  @Bean
  public CommandLineRunner loadData(InventoryRepository inventoryrepository) {
    return args -> {
      Inventory inventory = new Inventory();
      inventory.setSkuCode("iphone_14");
      inventory.setQuantity(100);

      Inventory inventory1 = new Inventory();
      inventory1.setSkuCode("iphone_13");
      inventory1.setQuantity(0);

      inventoryrepository.save(inventory);
      inventoryrepository.save(inventory1);
    };
  }
}
