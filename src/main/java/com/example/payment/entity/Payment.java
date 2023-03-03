package com.example.payment.entity;


import com.example.payment.entity.enumClass.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "payments", schema = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

    @Column(name = "sum_of_favour")
    @NotEmpty(message = "Обязательно добавьте сумму")
    @Min(500)
    @Max(25000)
    private Integer sumOfFavour;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "favour_id")
    private Favour favour;

    @Column(name = "account_check")
    @NotEmpty(message = "Реквизиты не должны быть пустыми!")
    private String accountCheck;

    @Column(name = "is_checked")
    private Boolean isChecked;

    @Column(name = "finished")
    private Boolean finished;
}
