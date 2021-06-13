package com.mkamalova.readingisgood.service;

import com.mkamalova.readingisgood.rest.CustomerRequest;
import com.mkamalova.readingisgood.rest.CustomerResponse;
import com.mkamalova.readingisgood.rest.OrderRequest;
import com.mkamalova.readingisgood.rest.OrdersResponse;
import org.springframework.http.ResponseEntity;

public interface IOrderService
{
    ResponseEntity<OrdersResponse> activateOrder(OrderRequest request);

}
