package com.mkamalova.readingisgood.service.impl;

import com.mkamalova.readingisgood.entity.Order;
import com.mkamalova.readingisgood.enumaration.EnumOrderStatus;
import com.mkamalova.readingisgood.enumaration.EnumResponseMessage;
import com.mkamalova.readingisgood.repository.OrderRepository;
import com.mkamalova.readingisgood.rest.BookResponse;
import com.mkamalova.readingisgood.rest.OrderRequest;
import com.mkamalova.readingisgood.rest.OrdersResponse;
import com.mkamalova.readingisgood.rest.UpdateBooksStockRequest;
import com.mkamalova.readingisgood.service.IOrderService;
import com.mkamalova.readingisgood.util.ReadingIsGoodException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {


    private final OrderRepository orderRepository;
    private final BookServiceImpl bookService;

    @Override
    public ResponseEntity<OrdersResponse> activateOrder(OrderRequest request)
    {
        OrdersResponse response = new OrdersResponse();
        AtomicReference<Integer> orderTotalAmount = new AtomicReference<>(0);

            request.getOrderData().stream().forEach(p-> {
                ResponseEntity<BookResponse> bookResponse = bookService.updateStock(UpdateBooksStockRequest.builder()
                        .bookId(p.getBookId())
                        .quantity(p.getQuantity()).build());
                orderTotalAmount.updateAndGet(v -> v + (bookResponse.getBody().getAmount()*p.getQuantity()));
            });

            Order newOrder = orderRepository.save(Order.builder()
            .orderId(UUID.randomUUID().toString())
            .customerId(request.getCustomerId())
            .totalAmount(orderTotalAmount.get())
            .orderData(request.getOrderData())
            .status(EnumOrderStatus.ACTIVE)
            .orderDate(LocalDateTime.now()).build());

           response.setResponseCode(EnumResponseMessage.RC_SUCCESS.getResponseCode());
           response.setResponseMessage(EnumResponseMessage.RC_SUCCESS.getResponseDesc());
           response.setCustomerId(newOrder.getCustomerId());
           response.setOrderId(newOrder.getOrderId());
           response.setOrderData(newOrder.getOrderData());
           response.setTotalAmount(newOrder.getTotalAmount());
           response.setOrderDate(newOrder.getOrderDate());


        return ResponseEntity.ok(response);
    }
}
