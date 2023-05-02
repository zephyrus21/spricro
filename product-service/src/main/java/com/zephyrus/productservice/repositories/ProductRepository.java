package com.zephyrus.productservice.repositories;

import com.zephyrus.productservice.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
