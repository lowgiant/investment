package com.fastcampus.investment.services;

import com.fastcampus.investment.model.*;
import com.fastcampus.investment.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final ProductService productService;

    public UserEntity userAdd(Long id,UserRequest request){
        ProductEntity product = productService.productById(request.getProductId());
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(id);
        userEntity.setInvestedAmount(request.getInvestAmount());
        userEntity.setProductId(request.getProductId());
        userEntity.setProductEntity(product);
        userEntity.setInvestedAt(LocalDate.now());

        if(request.getInvestAmount() + sumProductInvestAmount(id) >= product.getTotalInvestAmount()){
            userEntity.setStatus(UserInvestmentStatus.FAIL);
        } else {
            userEntity.setStatus(UserInvestmentStatus.INVESTED);
        }

        return this.userRepository.save(userEntity);
    }

    public List<UserResponse> findInvestByUserId(long userId) {
        return userRepository.findByUserId(userId).stream()
                .map(UserResponse::new).collect(Collectors.toList());
    }

    public long sumProductInvestAmount(long userId) {
        return userRepository.findByUserIdAndStatus(userId, UserInvestmentStatus.INVESTED).stream()
                .map(UserEntity::getInvestedAmount).reduce(0L, Long::sum);
    }

    public int investTotalCount(long productId) {
        return (int) userRepository.findByProductIdAndStatus(productId, UserInvestmentStatus.INVESTED).stream()
                .distinct().count();
    }

    public long sumProductInvestment(long productId) {
        return userRepository.findByProductIdAndStatus(productId, UserInvestmentStatus.INVESTED).stream()
                .map(UserEntity::getInvestedAmount).reduce(0L, Long::sum);
    }

    public void cancelInvestment(long investId ,long userId){
        UserEntity user = userRepository.findByIdAndUserIdAndStatus(investId,userId, UserInvestmentStatus.INVESTED);
        user.setStatus(UserInvestmentStatus.CANCELED);
        userRepository.save(user);
    }

    public List<ProductResponse> findAllProductValid() {
        List<ProductEntity> result = productService.findValidProducts();
        List<ProductResponse> response = result.stream().map(ProductResponse::new).collect(Collectors.toList());
        response.forEach(product -> {
            product.setInvestedCount(this.investTotalCount(product.getId()));
            product.setInvestedAmount(this.sumProductInvestment(product.getId()));
        });
        return response;
    }

}
