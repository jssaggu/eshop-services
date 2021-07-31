package com.saggu.eshop.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@Builder
@ToString
public class OrderDto {
    private String orderId;
    private CustomerDto customer;
    private List<ProductDto> products;
}