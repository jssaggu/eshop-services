package com.saggu.eshop.dto;

import com.saggu.eshop.dao.ProductDao;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class ProductDto {
    private final String fromServerId = ProductDao.instanceId;
    private String productId;
    private String productName;
}