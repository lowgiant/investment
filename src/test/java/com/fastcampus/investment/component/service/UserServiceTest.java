package com.fastcampus.investment.component.service;

import com.fastcampus.investment.component.entity.UserEntity;
import com.fastcampus.investment.component.repository.UserRepository;
import com.fastcampus.investment.util.type.UserInvestingType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    @DisplayName("buyProduct() Test")
    @Test
    void test_2(){
        userRepository.save(UserEntity.builder()
                        .id(1L)
                        .holdingAmount(1_000_000L)
                        .investedAmount(0L)
                        .status(UserInvestingType.NONE)
                        .investedCount(0)
                .build());

        UserEntity user = userService.payForProduct(1L, 10000L);
        System.out.println(user);

        user = userService.payForProduct(1L, 200000L);
        System.out.println(user);
    }


}