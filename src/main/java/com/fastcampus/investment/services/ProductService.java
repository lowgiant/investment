package com.fastcampus.investment.services;

import com.fastcampus.investment.model.ProductEntity;
import com.fastcampus.investment.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public ProductEntity productById(Long id) {
        return this.productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public List<ProductEntity> findValidProducts() {
        return productRepository.findByStartedAtLessThanEqualAndFinishedAtGreaterThanEqual(LocalDate.now(), LocalDate.now());
    }

}
