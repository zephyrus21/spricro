package com.zephyrus.productservice.services;

import com.zephyrus.productservice.dto.ProductRequest;
import com.zephyrus.productservice.dto.ProductResponse;
import com.zephyrus.productservice.models.Product;
import com.zephyrus.productservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
  private final ProductRepository productRepository;

  public void createProduct(ProductRequest productRequest) {
    Product product = Product.builder()
        .name(productRequest.getName())
        .description(productRequest.getDescription())
        .price(productRequest.getPrice())
        .build();

    productRepository.save(product);

    log.info("Product created: {}", product);
  }

  public List<ProductResponse> getAllProducts() {
    List<Product> products = productRepository.findAll();

    return products.stream().map(this::mapToProductResponse).toList();
  }

  private ProductResponse mapToProductResponse(Product product) {
    return ProductResponse.builder()
        .id(product.getId())
        .name(product.getName())
        .description(product.getDescription())
        .price(product.getPrice())
        .build();
  }
}
