package com.example.payment.dto;


import com.example.payment.entity.FavourCategory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class FavourRequest {

    private Integer id;

    private String title;

    private String description;

    private FavourCategory favourCategory;
}
