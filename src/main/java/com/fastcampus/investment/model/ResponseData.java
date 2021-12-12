package com.fastcampus.investment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseData {
    private String status;

    public ResponseData(String status) {
        this.status = status;
    }
}
