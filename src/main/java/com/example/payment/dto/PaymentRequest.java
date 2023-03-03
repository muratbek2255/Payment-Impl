package com.example.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
public class PaymentRequest {

    private Integer price;

    private String accountCheck;

    private FavourRequest favourRequest;
}
