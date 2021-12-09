package com.fastcampus.investment.component.service;

import com.fastcampus.investment.component.entity.ProductsEntity;
import com.fastcampus.investment.component.entity.UserEntity;
import com.fastcampus.investment.component.repository.ProductsRepository;
import com.fastcampus.investment.component.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class InvestingServiceTest {
    @Autowired
    InvestingService investingService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductsRepository productsRepository;

    @DisplayName("Transaction Test")
    @Test
    @Transactional
    void test_3(){
        UserEntity user1 = userRepository.findById(1L).orElseThrow(RuntimeException::new);

        investingService.doInvest(1L, 1L, 1_000_000L);

        userRepository.findAll().get(0).getInvestingStatus().forEach(o-> System.out.println(o.getProducts()));


    }


}