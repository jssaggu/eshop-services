package com.saggu.eshop.controller;

import com.saggu.eshop.dao.ProductDao;
import com.saggu.eshop.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class ProductService {

    @GetMapping(value = "/products/{productId}")
    public ResponseEntity<ProductDto> productById(@PathVariable("productId") String productId) {
        Optional<ProductDto> product = ProductDao.getProduct(productId);

        if (product.isPresent()) {
            return ok(product.get());
        }

        return notFound().build();
    }
}
