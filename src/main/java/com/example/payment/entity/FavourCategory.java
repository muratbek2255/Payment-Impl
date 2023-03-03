package com.example.payment.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "favour_categories")
public class FavourCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 70, message = "Название должно быть от 2 до 70 символов длиной")
    private String title;

    @OneToMany(mappedBy = "parent")
    private List<FavourCategory> childs;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private FavourCategory parent;
}
