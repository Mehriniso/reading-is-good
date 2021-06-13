package com.mkamalova.readingisgood.rest;

import com.mkamalova.readingisgood.entity.OrderData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrdersResponse {

    private String responseCode;

    private  String responseMessage;

    private String orderId;

    private String customerId;

    private List<OrderData> orderData;

    private Integer totalAmount;

    private LocalDateTime orderDate;

}
