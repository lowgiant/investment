package com.fastcampus.investment.component.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvestingStatusDTO {
    private Long id;

    private Product product;

    private Long investedAmount;

    private String status;

    private LocalDate investedAt;

    @Data
    @AllArgsConstructor
    public static class Product{
        private Long id;
        private String title;
        private Long totalInvestAmount;
    }

}
