package com.fastcampus.investment.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponse {
    private Long id;
    private Long userId;
    private ProductEntity product;
    private LocalDate investedAt;
    private long investedAmount;
    private UserInvestmentStatus status;

    public UserResponse(UserEntity user) {
        id = user.getId();
        userId = user.getId();
        product = user.getProductEntity();
        investedAt = user.getInvestedAt();
        status = user.getStatus();
        this.investedAmount = user.getInvestedAmount();
    }

}
