package com.example.payment.service;

import com.example.payment.dto.FavourAddChildCategoryRequest;
import com.example.payment.dto.FavourCategoryRequest;
import com.example.payment.entity.FavourCategory;
import com.example.payment.repository.FavourCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FavourCategoryServiceImpl implements FavourServiceCategory{

    private final FavourCategoryRepository favourCategoryRepository;

    @Autowired
    public FavourCategoryServiceImpl(FavourCategoryRepository favourCategoryRepository) {
        this.favourCategoryRepository = favourCategoryRepository;
    }

    @Override
    public List<FavourCategory> getAllFavourCategory() {

        List<FavourCategory> favourCategories = favourCategoryRepository.findAll();

        return favourCategories;

    }

    @Override
    public FavourCategory getByIdFavourCategory(int id) {

        FavourCategory favourCategory = favourCategoryRepository.getById(id);

        return favourCategory;

    }

    @Override
    public String addCategory(FavourCategoryRequest favourCategoryRequest) {

        FavourCategory favourCategory = new FavourCategory();

        favourCategory.setId(favourCategoryRequest.getId());
        favourCategory.setTitle(favourCategoryRequest.getTitle());

        favourCategoryRepository.save(favourCategory);

        return "Category Created!";
    }

    @Override
    public String updateCategory(FavourCategoryRequest favourCategoryRequest, int id) {

        FavourCategory favourCategory = favourCategoryRepository.getById(id);

        favourCategory.setTitle(favourCategoryRequest.getTitle());

        favourCategoryRepository.save(favourCategory);

        return "Category Update!";
    }

    @Override
    public String deleteCategory(int id) {

        FavourCategory favourCategory = favourCategoryRepository.getById(id);

        favourCategoryRepository.deleteById(favourCategory.getId());

        return "Category Delete!";
    }
    
    public void addParentCategory(FavourAddChildCategoryRequest favourAddChildCategoryRequest, int id) {
        
        FavourCategory favourCategory = favourCategoryRepository.getById(id);
        
        FavourCategory favourCategory1 = getByIdFavourCategory(favourAddChildCategoryRequest.getFavourCategory().getId());
        
        favourCategory.setParent(favourCategory1);
        
        favourCategoryRepository.save(favourCategory);
    }
    
    public void removeParentCategory(int id) {

        FavourCategory favourCategory = favourCategoryRepository.getById(id);
        
        favourCategory.setParent(null);
        
        favourCategoryRepository.save(favourCategory);

    }
}
