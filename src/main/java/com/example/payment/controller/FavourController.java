package com.example.payment.controller;


import com.example.payment.dto.FavourRequest;
import com.example.payment.entity.Favour;
import com.example.payment.service.FavourServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/favour")
public class FavourController {

    private final FavourServiceImpl favourService;

    @Autowired
    public FavourController(FavourServiceImpl favourService) {
        this.favourService = favourService;
    }

    @GetMapping
    public ResponseEntity<List<Favour>> getAllFavour() {

        return ResponseEntity.status(200).body(favourService.getAllFavour());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Favour> getByIdFavor(@PathVariable int id) {

        return ResponseEntity.status(200).body(favourService.getByIdFavor(id));

    }

    @PostMapping
    public ResponseEntity<String> createFavor(@RequestBody FavourRequest favourRequest) {

        return ResponseEntity.status(201).body(favourService.createFavour(favourRequest));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delFavor(@PathVariable int id) {

        return ResponseEntity.status(202).body(favourService.deleteFavour(id));

    }

    @GetMapping("/favour-categories-by-id/{id}")
    public ResponseEntity<List<Favour>> getFavorByCategoryId(@PathVariable int id) {

        return ResponseEntity.status(200).body(favourService.getByIdFavorCategory(id));

    }
}
