package com.example.payment.dto;

import com.example.payment.entity.FavourCategory;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class FavourAddChildCategoryRequest {
    private FavourCategory favourCategory;
}
