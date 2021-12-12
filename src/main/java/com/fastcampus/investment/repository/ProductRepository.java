package com.fastcampus.investment.repository;

import com.fastcampus.investment.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByStartedAtLessThanEqualAndFinishedAtGreaterThanEqual(LocalDate startedAt, LocalDate finishedAt);
}
