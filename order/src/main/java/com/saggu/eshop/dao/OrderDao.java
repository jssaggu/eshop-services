package com.saggu.eshop.dao;

import com.saggu.eshop.dto.CustomerDto;
import com.saggu.eshop.dto.OrderDto;
import com.saggu.eshop.dto.ProductDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Optional;

import static java.lang.String.format;
import static java.util.List.of;
import static java.util.Optional.ofNullable;

@Component
public class OrderDao {
    @Value("${eshop.host-names.customers:localhost}")
    private String hostNameCustomers;

    @Value("${eshop.host-names.products:localhost}")
    private String hostNameProducts;

    private static final String CUSTOMER_URI = "http://%s:8081/customers/%s";
    private static final String PRODUCT_URI = "http://%s:8082/products/%s";

    private Map<String, OrderDto> orders;

    private final RestTemplate restTemplate;

    @PostConstruct
    public void init() {
        System.out.println("Host Customers: " + hostNameCustomers);
        System.out.println("Host Products: " + hostNameProducts);
        orders = Map.of(
                "O100", OrderDto.builder()
                        .orderId("O100")
                        .customer(getCustomer("C100").get())
                        .products(of(getProduct("P100").get())).build(),
                "O200", OrderDto.builder()
                        .orderId("O200")
                        .customer(getCustomer("C200").get())
                        .products(of(getProduct("P100").get(), getProduct("P200").get())).build(),
                "O300", OrderDto.builder()
                        .orderId("O300")
                        .customer(getCustomer("C300").get())
                        .products(of(getProduct("P200").get(), getProduct("P300").get())).build()
        );
    }

    public OrderDao(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    private Optional<ProductDto> getProduct(String productId) {
       return ofNullable(
               restTemplate
                       .getForObject(
                               format(PRODUCT_URI, hostNameProducts, productId),
                               ProductDto.class));
    }

    private Optional<CustomerDto> getCustomer(String customerId) {
        return ofNullable(
                restTemplate
                        .getForObject(
                                format(CUSTOMER_URI, hostNameCustomers, customerId),
                                CustomerDto.class));
    }

    public Optional<OrderDto> getOrder(String orderId) {
        return ofNullable(orders.get(orderId));
    }
}
