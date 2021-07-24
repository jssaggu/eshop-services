package com.saggu.eshop.controller;

import com.saggu.eshop.dao.CustomerDao;
import com.saggu.eshop.dto.CustomerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.ok;

@RestController
public class CustomerService {

    @GetMapping(value = "/customers/{customerId}")
    public ResponseEntity<CustomerDto> customerById(@PathVariable("customerId") String customerId) {
        Optional<CustomerDto> customer = CustomerDao.getCustomer(customerId);

        if (customer.isPresent()) {
            return ok(customer.get());
        }

        return notFound().build();
    }
}
