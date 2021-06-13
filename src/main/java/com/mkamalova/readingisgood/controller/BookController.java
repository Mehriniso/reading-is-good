package com.mkamalova.readingisgood.controller;

import com.mkamalova.readingisgood.rest.BookRequest;
import com.mkamalova.readingisgood.rest.BookResponse;
import com.mkamalova.readingisgood.rest.CustomerRequest;
import com.mkamalova.readingisgood.rest.CustomerResponse;
import com.mkamalova.readingisgood.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor

public class BookController
{
    private final IBookService bookService;

    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<BookResponse> saveCustomer(@Valid @RequestBody BookRequest request)
    {
        return bookService.saveBook(request);
    }
}
