package com.mkamalova.readingisgood.entity;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name= "CUSTOMER")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
    @Column(name ="ID")
    @NotNull
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private String customerId;

    @Column(name ="FIRST_NAME")
    @NotNull
    private String firstName;

    @Column(name ="LAST_NAME")
    @NotNull
    private String lastName;

    @Column(name ="EMAIL")
    @NotNull
    private String eMail;

    @Column(name ="ADDRESS")
    @NotNull
    private String address;

    @Column(name ="PHONE_NUMBER")
    @NotNull
    private Integer phoneNumber;
}
