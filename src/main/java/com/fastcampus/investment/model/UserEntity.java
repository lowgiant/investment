package com.fastcampus.investment.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invest_id", nullable = false)
    private Long id;
    private Long userId;
    private Long productId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private ProductEntity productEntity;
    private Long investedAmount;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private UserInvestmentStatus status;
    private LocalDate investedAt;

}
