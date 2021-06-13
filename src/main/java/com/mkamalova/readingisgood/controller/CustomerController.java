package com.mkamalova.readingisgood.controller;

import com.mkamalova.readingisgood.rest.CustomerRequest;
import com.mkamalova.readingisgood.rest.CustomerResponse;
import com.mkamalova.readingisgood.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController
{
    private  final ICustomerService customerService;

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<CustomerResponse> saveCustomer(@Valid @RequestBody CustomerRequest request)
    {
        return customerService.addNewCustomer(request);
    }

}
