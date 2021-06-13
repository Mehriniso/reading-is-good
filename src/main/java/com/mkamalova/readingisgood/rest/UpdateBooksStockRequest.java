package com.mkamalova.readingisgood.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateBooksStockRequest
{
    @NotNull(message="bookId can not be null")
    private String bookId;

    @NotNull(message="stock amount can not be null")
    private Integer quantity;
}
