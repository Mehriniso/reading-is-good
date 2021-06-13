package com.mkamalova.readingisgood.controller;

import com.mkamalova.readingisgood.enumaration.EnumResponseMessage;
import com.mkamalova.readingisgood.rest.ErrorHandlerResponse;
import com.mkamalova.readingisgood.util.ReadingIsGoodException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@Slf4j
@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler
{
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ReadingIsGoodException.class})
    public ResponseEntity<Object> handleInvalidInputException(ReadingIsGoodException ex) {
       log.error("Invalid Input Exception: ",ex.getMessage());
        return ResponseEntity.badRequest().body(genericErrorResponseBody(ex, ex.getEnumResponseMessage()));
    }


    public ResponseEntity<Object> handleException(Exception ex) {
        log.error("Exception: ",ex.getMessage());
        return ResponseEntity.badRequest().body(genericErrorResponseBody(ex, EnumResponseMessage.RC_INVALID_REQUEST));
    }


    private ErrorHandlerResponse genericErrorResponseBody(Exception ex, EnumResponseMessage responseMessage) {

        ErrorHandlerResponse errorHandlerResponse = new ErrorHandlerResponse();
        errorHandlerResponse.setRequestTimestamp(LocalDateTime.now());
        errorHandlerResponse.setResponseCode(responseMessage.getResponseCode());
        errorHandlerResponse.setResponseDescription(responseMessage.getResponseDesc());
        if (StringUtils.isNotEmpty(ex.getMessage()))
            errorHandlerResponse.setErrorDetails(ex.getMessage());
        return errorHandlerResponse;
    }



}
