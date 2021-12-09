package com.fastcampus.investment.component.dto;

import com.fastcampus.investment.component.entity.InvestingStatusEntity;
import lombok.ToString;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsDTO {

    private Long id;

    private String title;

    private Long totalInvestAmount;

    private int investedCount;

    private Long investedAmount;

    private LocalDate startedAt;

    private LocalDate finishedAt;
    @ToString.Exclude
    @Builder.Default
    private List<InvestingStatusEntity> investingStatus = new ArrayList<>();


}
