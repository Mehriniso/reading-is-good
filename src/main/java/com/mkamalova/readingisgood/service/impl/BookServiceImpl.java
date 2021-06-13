package com.mkamalova.readingisgood.service.impl;

import com.mkamalova.readingisgood.entity.Book;
import com.mkamalova.readingisgood.enumaration.EnumResponseMessage;
import com.mkamalova.readingisgood.repository.BookRepository;
import com.mkamalova.readingisgood.rest.BookRequest;
import com.mkamalova.readingisgood.rest.BookResponse;
import com.mkamalova.readingisgood.rest.UpdateBooksStockRequest;
import com.mkamalova.readingisgood.service.IBookService;
import com.mkamalova.readingisgood.util.ReadingIsGoodException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements IBookService
{
    private final BookRepository repository;
    @Override
    public ResponseEntity<BookResponse> saveBook(BookRequest request)
    {
        BookResponse bookResponse = new BookResponse();
        try
        {
            Book loadedBook = repository.getById(request.getBookId());
            if(loadedBook==null)
            {
                throw new ReadingIsGoodException(EnumResponseMessage.RC_BOOK_IS_NOT_EXIST.getResponseDesc(), EnumResponseMessage.RC_BOOK_IS_NOT_EXIST);

            }

            Book updatedBook = repository.save(Book.builder()
                    .bookId(UUID.randomUUID().toString())
                    .name(request.getName())
                    .author(request.getAuthor())
                    .amount(request.getAmount())
                    .quantity(request.getQuantity()).build());

            bookResponse.setResponseCode(EnumResponseMessage.RC_SUCCESS.getResponseCode());
            bookResponse.setResponseMessage(EnumResponseMessage.RC_SUCCESS.getResponseDesc());
            bookResponse.setBookId(updatedBook.getBookId());
            bookResponse.setName(updatedBook.getName());
            bookResponse.setAuthor(updatedBook.getAuthor());
            bookResponse.setAmount(updatedBook.getAmount());
            bookResponse.setQuantity(updatedBook.getQuantity());

        }

        catch (Exception ex)
        {
            throw  new ReadingIsGoodException(ex.getMessage(), EnumResponseMessage.RC_ERROR);
        }
        return  ResponseEntity.ok(bookResponse);
    }

    @Override
    public ResponseEntity<BookResponse> updateStock(UpdateBooksStockRequest request)
    {

        BookResponse bookResponse = new BookResponse();

            Book loadedBook = repository.getById(request.getBookId());
            if(loadedBook==null)
            {
                throw new ReadingIsGoodException(EnumResponseMessage.RC_BOOK_IS_NOT_EXIST.getResponseDesc(), EnumResponseMessage.RC_BOOK_IS_NOT_EXIST);

            }
            if(request.getQuantity()>loadedBook.getQuantity())
            {
                throw new ReadingIsGoodException(EnumResponseMessage.RC_BOOK_STOCK_ERROR.getResponseDesc(), EnumResponseMessage.RC_BOOK_STOCK_ERROR);
            }


            loadedBook.setQuantity(loadedBook.getQuantity() - request.getQuantity());
            repository.save(loadedBook);

            bookResponse.setResponseCode(EnumResponseMessage.RC_SUCCESS.getResponseCode());
            bookResponse.setResponseMessage(EnumResponseMessage.RC_SUCCESS.getResponseDesc());
            bookResponse.setBookId(loadedBook.getBookId());
            bookResponse.setName(loadedBook.getName());
            bookResponse.setAuthor(loadedBook.getAuthor());
            bookResponse.setAmount(loadedBook.getAmount());
            bookResponse.setQuantity(loadedBook.getQuantity());


        return  ResponseEntity.ok(bookResponse);

    }


    private void validate()
    {

    }
}
