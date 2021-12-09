package com.fastcampus.investment.component.dto;

import lombok.Data;

@Data
public class ResponseDTO<T> {

    private T data;

    public ResponseDTO(T data){
        this.data = data;
    }

}
