package com.mkamalova.readingisgood.rest;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookRequest {


    private String bookId;

    @NotNull(message="name can not be null")
    @Length(max = 250)
    private String name;

    @NotNull(message="name can not be null")
    @Length(max = 250)
    private String author;

    @NotNull(message="quantity can not be null")
    private Integer quantity;

    @NotNull(message="amount can not be null")
    private Integer amount;
}
