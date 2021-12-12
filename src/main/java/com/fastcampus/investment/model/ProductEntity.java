package com.fastcampus.investment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name ="products")
@NoArgsConstructor
@AllArgsConstructor

public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(name = "total_investing_amount", nullable = false)
    private Long totalInvestAmount;

    @Column(name ="started_at", nullable = false)
    private LocalDate startedAt;

    @Column(name ="finished_at", nullable = false)
    private LocalDate finishedAt;
}
