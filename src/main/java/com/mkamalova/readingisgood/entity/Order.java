package com.mkamalova.readingisgood.entity;

import com.mkamalova.readingisgood.enumaration.EnumOrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import com.mkamalova.readingisgood.util.JsonUserType;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "ORDERS")
@AllArgsConstructor
@NoArgsConstructor
@TypeDef(name = "jsonMap", typeClass = JsonUserType.class)
@Builder
public class Order {

    @Id
    @Column(name= "ID")
    @NotNull
    private String orderId;

    @Column(name ="CUSTOMER_ID")
    @NotNull
    private String customerId;

    @Column(name = "ORDER_DATA")
    @NotNull
    @Type(type = "jsonMap", parameters = {
            @org.hibernate.annotations.Parameter(name = "classType", value = "java.util.List")
    })
    private List<OrderData> orderData;

    @Column(name = "TOTAL_AMOUNT")
    @NotNull
    private Integer totalAmount;

    @Column(name= "ORDER_DATE")
    @NotNull
    private LocalDateTime orderDate;

    @Column(name = "STATUS")
    @NotNull
    @Enumerated(value = EnumType.STRING)
    private EnumOrderStatus status;

}


