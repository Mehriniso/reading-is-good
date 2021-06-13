package com.mkamalova.readingisgood.rest;

import com.mkamalova.readingisgood.entity.OrderData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderRequest {

    @NotNull(message="customerId can not be null")
    private String customerId;

    @NotNull(message="orderData can not be null")
    private List<OrderData> orderData;


}
