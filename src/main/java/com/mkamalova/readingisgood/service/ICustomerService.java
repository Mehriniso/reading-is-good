package com.mkamalova.readingisgood.service;

import com.mkamalova.readingisgood.rest.CustomerRequest;
import com.mkamalova.readingisgood.rest.CustomerResponse;
import org.springframework.http.ResponseEntity;

public interface ICustomerService {

    ResponseEntity<CustomerResponse> addNewCustomer(CustomerRequest request);


}
