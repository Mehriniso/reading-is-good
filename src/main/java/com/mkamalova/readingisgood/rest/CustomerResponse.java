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
public class CustomerResponse {

    private String responseCode;

    private  String responseMessage;

    private String customerId;

    private String firstName;

    private String lastName;

    private String eMail;

    private String address;

    private Integer phoneNumber;

}
