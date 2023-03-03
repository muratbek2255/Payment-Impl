package com.example.payment.repository;

import com.example.payment.entity.Favour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavourRepository extends JpaRepository<Favour, Integer> {

    @Query(value = "SELECT * FROM payment.favours WHERE payment.favours.id = ?1", nativeQuery = true)
    Favour getByFavourId(@Param("id") int id);

    @Query(value = "SELECT * FROM payment.favours WHERE payment.favours.fk_category_id = ?1", nativeQuery = true)
    List<Favour> getFavourByCategoryId(@Param("id") int id);
}
