package com.fastcampus.investment.util.mapper.entity;

import com.fastcampus.investment.component.dto.ProductsDTO;
import com.fastcampus.investment.component.entity.ProductsEntity;
import com.fastcampus.investment.util.mapper.ProductsMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductsMapperTest {


    @DisplayName("MapperTest")
    @Test
    void test_1(){
        ProductsEntity productsEntity = ProductsEntity.builder()
                .id(1L)
                .title("테스트 제목")
                .investedCount(1)
                .investedAmount(1_000_000L)
                .totalInvestAmount(2_000_000L)
                .startedAt(LocalDate.now().minusDays(1L))
                .finishedAt(LocalDate.now().plusDays(1L))
                .investingStatus(new ArrayList<>())
                .build();

        System.out.println("Entity : " + productsEntity.toString());

        ProductsDTO productsDTO = ProductsMapper.INSTANCE.toDto(productsEntity);

        System.out.println("DTO : " + productsDTO.toString());
    }

}