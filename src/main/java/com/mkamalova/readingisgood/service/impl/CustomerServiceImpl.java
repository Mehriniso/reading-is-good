package com.mkamalova.readingisgood.service.impl;

import com.mkamalova.readingisgood.entity.Customer;
import com.mkamalova.readingisgood.enumaration.EnumResponseMessage;
import com.mkamalova.readingisgood.repository.CustomerRepository;
import com.mkamalova.readingisgood.repository.OrderRepository;
import com.mkamalova.readingisgood.rest.CustomerRequest;
import com.mkamalova.readingisgood.rest.CustomerResponse;
import com.mkamalova.readingisgood.service.ICustomerService;
import com.mkamalova.readingisgood.util.ReadingIsGoodException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService
{
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;


    @Override
    public ResponseEntity<CustomerResponse> addNewCustomer(CustomerRequest request)
    {
        CustomerResponse response = new CustomerResponse();
        log.debug(request.toString());

          Customer newCustomer = customerRepository.save( Customer.builder()
                  .customerId(UUID.randomUUID().toString())
                  .firstName(request.getFirstName())
                  .lastName(request.getLastName())
                  .address(request.getAddress())
                  .eMail(request.getEmail())
                  .phoneNumber(request.getPhoneNumber()).build());

          response.setResponseCode(EnumResponseMessage.RC_SUCCESS.getResponseCode());
          response.setResponseMessage(EnumResponseMessage.RC_SUCCESS.getResponseDesc());
          response.setCustomerId(newCustomer.getCustomerId());
          response.setFirstName(newCustomer.getFirstName());
          response.setLastName(newCustomer.getLastName());
          response.setAddress(newCustomer.getAddress());
          response.setEMail(newCustomer.getEMail());
          response.setPhoneNumber(newCustomer.getPhoneNumber());

          log.debug(response.toString());


        return ResponseEntity.ok(response);
    }

    public void validation(CustomerRequest request)
    {

    }

}
