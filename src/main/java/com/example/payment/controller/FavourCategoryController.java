package com.example.payment.controller;


import com.example.payment.dto.FavourAddChildCategoryRequest;
import com.example.payment.dto.FavourCategoryRequest;
import com.example.payment.entity.FavourCategory;
import com.example.payment.service.FavourCategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/favour-categories")
public class FavourCategoryController {

    private final FavourCategoryServiceImpl favourCategoryService;

    @Autowired
    public FavourCategoryController(FavourCategoryServiceImpl favourCategoryService) {
        this.favourCategoryService = favourCategoryService;
    }

    @GetMapping
    public ResponseEntity<List<FavourCategory>> getAllCategory() {
        return ResponseEntity.status(200).body(favourCategoryService.getAllFavourCategory());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FavourCategory> getByIdFavourCategory(@PathVariable int id) {

        return ResponseEntity.status(200).body(favourCategoryService.getByIdFavourCategory(id));

    }

    @PostMapping
    public ResponseEntity<String> addFavourCategory(@RequestBody FavourCategoryRequest favourCategoryRequest) {

        return ResponseEntity.status(201).body(favourCategoryService.addCategory(favourCategoryRequest));

    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFavourCategory(@RequestBody FavourCategoryRequest favourCategoryRequest,
                                                       @PathVariable int id) {

        return ResponseEntity.status(201).body(favourCategoryService.updateCategory(favourCategoryRequest, id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFavourCategory(@PathVariable int id) {

        return ResponseEntity.status(202).body(favourCategoryService.deleteCategory(id));

    }

    @PutMapping("/update-favour-category-child/{id}")
    public void updateFavourCategoryChild(@RequestBody FavourAddChildCategoryRequest favourCategoryRequest,
                                                            @PathVariable int id) {

        favourCategoryService.addParentCategory(favourCategoryRequest, id);

    }

    @DeleteMapping("/delete-favour-category-child/{id}")
    public void deleteFavourCategoryChild(@PathVariable int id) {
        favourCategoryService.removeParentCategory(id);
    }
}
