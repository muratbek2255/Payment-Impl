package com.example.payment.entity;

//        добавить новую сущность - услуга
//        добавить метод для проверки платежа (пройдет ли платёж)
//        платеж не создается пока успешную проверку не пройдет
//        проверка и создание -> новое поле айдишка услуги, проверяется учитывая услугу, создается платёж по какой-то услуге
//        прописать функционал по услугам, получение услуг, получение категории услуг (добавить категории)
//        у категории могут быть подкатегории и т.д, нужна вложенность

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@EqualsAndHashCode
@Table(name = "favours", schema = "payment")
public class Favour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "title")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 70, message = "Название должно быть от 2 до 70 символов длиной")
    private String title;

    @Column(name = "description")
    @NotEmpty(message = "Нужно добавить описание")
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_category_id")
    private FavourCategory favourCategory;
}
