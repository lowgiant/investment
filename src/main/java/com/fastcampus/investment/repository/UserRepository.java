package com.fastcampus.investment.repository;

import com.fastcampus.investment.model.UserEntity;
import com.fastcampus.investment.model.UserInvestmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByIdAndUserIdAndStatus(Long InvestId, Long userId, UserInvestmentStatus status);
    List<UserEntity> findByProductIdAndStatus(Long productId, UserInvestmentStatus status);
    List<UserEntity> findByUserId(Long userId);
    List<UserEntity> findByUserIdAndStatus(Long userId, UserInvestmentStatus status);


}
