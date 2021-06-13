package com.mkamalova.readingisgood.rest;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerRequest
{

    @NotNull(message="firstName can not be null")
    @Length(max = 250)
    private String firstName;

    @NotNull(message="lastName can not be null")
    @Length(max = 250)
    private String lastName;

    @NotNull(message="eMail can not be null")
    @Length(max = 250)
    private String email;

    @NotNull(message="address can not be null")
    @Length(max = 250)
    private String address;

    @NotNull(message="phoneNumber can not be null")
    private Integer phoneNumber;

}
