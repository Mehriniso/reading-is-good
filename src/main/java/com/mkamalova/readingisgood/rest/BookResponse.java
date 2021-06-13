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
public class BookResponse
{
    private String responseCode;

    private  String responseMessage;

    private String bookId;

    private String name;

    private String author;

    private Integer quantity;

    private Integer amount;
}
