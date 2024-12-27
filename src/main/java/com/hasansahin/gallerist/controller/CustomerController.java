package com.hasansahin.gallerist.controller;

import com.hasansahin.gallerist.dto.DtoCustomer;
import com.hasansahin.gallerist.dto.DtoCustomerIU;
import com.hasansahin.gallerist.service.CustomerService;
import com.hasansahin.gallerist.utils.RootEntity;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customer")
public class CustomerController extends BaseController{
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }
}
