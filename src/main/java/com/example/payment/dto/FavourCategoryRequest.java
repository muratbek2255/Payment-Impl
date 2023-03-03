package com.example.payment.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class FavourCategoryRequest {
    private Integer id;

    private String title;
}
