package com.mkamalova.readingisgood.controller;


import com.mkamalova.readingisgood.rest.OrderRequest;
import com.mkamalova.readingisgood.rest.OrdersResponse;
import com.mkamalova.readingisgood.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class OrderController
{
    private final IOrderService orderService;

    @PostMapping
    @RequestMapping("/activate")
    public ResponseEntity<OrdersResponse> activateOrder(@Valid @RequestBody OrderRequest request)
    {
        return orderService.activateOrder(request);
    }
}
