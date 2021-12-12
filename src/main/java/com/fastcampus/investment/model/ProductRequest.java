package com.fastcampus.investment.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class ProductRequest {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate finishedAt;

    private String texts;
}
