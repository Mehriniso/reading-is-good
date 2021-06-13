package com.mkamalova.readingisgood.service;

import com.mkamalova.readingisgood.rest.BookRequest;
import com.mkamalova.readingisgood.rest.BookResponse;

import com.mkamalova.readingisgood.rest.UpdateBooksStockRequest;
import org.springframework.http.ResponseEntity;

public interface IBookService
{
    ResponseEntity<BookResponse> saveBook(BookRequest request);
    ResponseEntity<BookResponse> updateStock(UpdateBooksStockRequest request);


}
