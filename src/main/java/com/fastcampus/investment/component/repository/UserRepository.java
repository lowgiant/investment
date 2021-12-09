package com.fastcampus.investment.component.repository;

import com.fastcampus.investment.component.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
