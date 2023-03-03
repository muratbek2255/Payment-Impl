package com.example.payment.service;

import com.example.payment.dto.FavourRequest;
import com.example.payment.entity.Favour;
import com.example.payment.entity.FavourCategory;
import com.example.payment.repository.FavourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FavourServiceImpl implements FavourService {

    private final FavourRepository favourRepository;

    private final FavourCategoryServiceImpl favourCategoryService;

    @Autowired
    public FavourServiceImpl(FavourRepository favourRepository, FavourCategoryServiceImpl favourCategoryService) {
        this.favourRepository = favourRepository;
        this.favourCategoryService = favourCategoryService;
    }

    @Override
    public List<Favour> getAllFavour() {

        List<Favour> favours = favourRepository.findAll();

        return favours;

    }

    @Override
    public Favour getByIdFavor(int id) {
        return favourRepository.getByFavourId(id);
    }

    @Override
    public String createFavour(FavourRequest favourRequest) {

        Favour favour = new Favour();

        FavourCategory favourCategory = favourCategoryService.getByIdFavourCategory(favourRequest.getFavourCategory().getId());

        favour.setTitle(favourRequest.getTitle());
        favour.setDescription(favourRequest.getDescription());
        favour.setFavourCategory(favourCategory);

        favourRepository.save(favour);

        return "Favour Created!";
    }

    @Override
    public String deleteFavour(int id) {

        favourRepository.deleteById(id);

        return "Favour delete!";

    }

    public List<Favour> getByIdFavorCategory(int id) {

        List<Favour> favour = favourRepository.getFavourByCategoryId(id);

        return favour;

    }
}
