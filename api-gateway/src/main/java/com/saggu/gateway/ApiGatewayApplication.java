package com.saggu.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import static java.lang.String.format;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
public class ApiGatewayApplication {

    private final String ROUTE_URI = "http://%s:%s";

    @Value("${eshop.host-names.customers:localhost}")
    private String hostNameCustomers;

    @Value("${eshop.host-names.products:localhost}")
    private String hostNameProducts;

    @Value("${eshop.host-names.orders:localhost}")
    private String hostNameOrders;

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customers", r -> r.path("/customers/*").uri(format(ROUTE_URI, hostNameCustomers, "8081")))
                .route("products", r -> r.path("/products/*").uri(format(ROUTE_URI, hostNameProducts, "8082")))
                .route("orders", r -> r.path("/orders/*").uri(format(ROUTE_URI, hostNameOrders, "8083")))
                .build();
    }
}