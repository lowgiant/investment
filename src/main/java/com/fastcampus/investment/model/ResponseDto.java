package com.fastcampus.investment.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ResponseDto<T> {
    private HttpStatus status;
    private T data;

    public ResponseDto(T data, HttpStatus status) {
        this.status = status;
        this.data = data;
    }

}