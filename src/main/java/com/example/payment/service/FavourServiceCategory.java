package com.example.payment.service;

import com.example.payment.dto.FavourCategoryRequest;
import com.example.payment.entity.FavourCategory;

import java.util.List;

public interface FavourServiceCategory {

    public List<FavourCategory> getAllFavourCategory();

    public FavourCategory getByIdFavourCategory(int id);

    public String addCategory(FavourCategoryRequest favourCategoryRequest);

    public String updateCategory(FavourCategoryRequest favourCategoryRequest, int id);

    public String deleteCategory(int id);
}
