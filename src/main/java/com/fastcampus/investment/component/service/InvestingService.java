package com.fastcampus.investment.component.service;

import com.fastcampus.investment.component.dto.InvestingStatusDTO;
import com.fastcampus.investment.component.entity.InvestingStatusEntity;
import com.fastcampus.investment.component.entity.ProductsEntity;
import com.fastcampus.investment.component.entity.UserEntity;
import com.fastcampus.investment.component.repository.InvestingStatusRepository;
import com.fastcampus.investment.component.repository.UserRepository;
import com.fastcampus.investment.util.mapper.InvestingStatusMapper;
import com.fastcampus.investment.util.type.UserInvestingType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class InvestingService {

    private final UserService userService;
    private final ProductService productService;
    private final InvestingStatusRepository investingStatusRepository;
    private final UserRepository userRepository;


    @Transactional(isolation = Isolation.READ_COMMITTED)
    public InvestingStatusDTO doInvest(Long userId, Long productsId, Long investAmount){

        UserEntity user = userService.payForProduct(userId, investAmount);
        ProductsEntity products ;

        // Status 가 FAIL 이면 투자 실패
        if (user.getStatus() == UserInvestingType.FAIL){
            products = productService.selectFail(productsId);
        // 투자 성공 시 투자 상품에 반영
        } else {
            products = productService.selectProduct(productsId, investAmount);
        }

        return addInvestingStatus(user, products);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public List<InvestingStatusDTO> getInvest(Long userId){
        UserEntity user = userRepository.findById(userId).orElseThrow(IllegalAccessError::new);
        return InvestingStatusMapper.INSTANCE.toDtoList(user.getInvestingStatus());
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public InvestingStatusEntity updateInvest(Long userId, Long productsId, String status){
        InvestingStatusEntity entity = investingStatusRepository.findByUserIdAndProductsId(userId, productsId);
        UserInvestingType type = UserInvestingType.valueOf(status);
        entity.getUser().setStatus(type);

        return investingStatusRepository.save(entity);
    }

    public InvestingStatusDTO addInvestingStatus(UserEntity user, ProductsEntity products){

        InvestingStatusEntity investingStatus = new InvestingStatusEntity();
        investingStatus.setUser(user);
        investingStatus.setProducts(products);
        investingStatusRepository.save(investingStatus);

        return InvestingStatusMapper.INSTANCE.toDto(investingStatus);
    }

}
