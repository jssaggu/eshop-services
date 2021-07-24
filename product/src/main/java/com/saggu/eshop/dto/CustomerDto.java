package com.saggu.eshop.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class CustomerDto {
    private String customerId;
    private String customerName;
}