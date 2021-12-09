package com.fastcampus.investment.component.service;

import com.fastcampus.investment.component.entity.UserEntity;
import com.fastcampus.investment.component.repository.UserRepository;
import com.fastcampus.investment.exception.IllegalUserException;
import com.fastcampus.investment.util.type.UserInvestingType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserEntity payForProduct(Long userId, Long investAmount) {
        UserEntity user = userRepository.findById(userId).orElseThrow(IllegalUserException::new);

        if (user.getHoldingAmount() < investAmount
         || user.getHoldingAmount() >= 100_000_000_000L
         || investAmount >= 100_000_000_000L)
        {
            user.setInvestedAmount(investAmount);
            user.setStatus(UserInvestingType.FAIL);
            user.setInvestedAt(LocalDate.now());
            return user;
        }

        user.setInvestedAmount(user.getInvestedAmount()+investAmount);
        user.setHoldingAmount(user.getHoldingAmount()-investAmount);
        user.setInvestedCount(user.getInvestedCount()+1);
        user.setStatus(UserInvestingType.INVESTED);
        user.setInvestedAt(LocalDate.now());

        return user;
    }
}
