package com.mkamalova.readingisgood.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.dynamic.scaffold.TypeWriter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="BOOK")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book  {

    @Id
    @NotNull
    @Column(name = "ID")
    private String bookId;

    @NotNull
    @Column(name= "NAME")
    private String name;

    @NotNull
    @Column(name= "AUTHOR")
    private String author;

    @NotNull
    @Column(name= "QUANTITY")
    private Integer quantity;

    @NotNull
    @Column(name ="AMOUNT")
    private Integer amount;
}


