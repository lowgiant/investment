package com.fastcampus.investment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductResponse {
    private Long id;

    private String title;

    private Long totalInvestAmount;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startedAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishedAt;

    private Long investedAmount = 0L;

    private Integer investedCount = 0;

    public ProductResponse(ProductEntity productEntity) {
       id = productEntity.getId();
       title = productEntity.getTitle();
       totalInvestAmount = productEntity.getTotalInvestAmount();
       startedAt = productEntity.getStartedAt();
       finishedAt = productEntity.getFinishedAt();

    }

}