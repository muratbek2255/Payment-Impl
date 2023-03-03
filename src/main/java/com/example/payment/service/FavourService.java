package com.example.payment.service;

import com.example.payment.dto.FavourRequest;
import com.example.payment.entity.Favour;

import java.util.List;

public interface FavourService {

    public List<Favour> getAllFavour();

    public Favour getByIdFavor(int id);

    public String createFavour(FavourRequest favourRequest);

    public String deleteFavour(int id);
}
