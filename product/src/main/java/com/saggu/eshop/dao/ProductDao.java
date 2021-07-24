package com.saggu.eshop.dao;

import com.saggu.eshop.dto.ProductDto;

import java.util.Map;
import java.util.Optional;

public class ProductDao {

    static final Map<String, ProductDto> products = Map.of(
            "P100", ProductDto.builder().productId("P100").productName("Sony TV").build(),
            "P200", ProductDto.builder().productId("P200").productName("Samsung TV").build(),
            "P300", ProductDto.builder().productId("P300").productName("Dishwasher").build(),
            "P400", ProductDto.builder().productId("P400").productName("Apple MacBook").build()
    );

    public static Optional<ProductDto> getProduct(String productId) {
        return Optional.ofNullable(products.get(productId));
    }
}
