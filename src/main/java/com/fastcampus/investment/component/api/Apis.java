package com.fastcampus.investment.component.api;

import com.fastcampus.investment.component.dto.InvestingStatusDTO;
import com.fastcampus.investment.component.dto.ProductsDTO;
import com.fastcampus.investment.component.dto.ResponseDTO;
import com.fastcampus.investment.component.service.InvestingService;
import com.fastcampus.investment.component.service.ProductService;
import com.fastcampus.investment.util.mapper.InvestingStatusMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class Apis {

    private final ProductService productService;
    private final InvestingService investingService;

    @GetMapping("/product")
    public ResponseDTO<List<ProductsDTO>> productGet(){
        return productService.lookupValidProducts();
    }

    @PostMapping("/investment")
    public ResponseDTO<InvestingStatusDTO> investmentPost(
            @RequestHeader("X-USER-ID") Long userId,
            @RequestParam Long productId,
            @RequestParam Long investAmount)
    {
        // post를 하면 성공한 invest 출력
        return new ResponseDTO<>(investingService.doInvest(userId, productId, investAmount));
    }

    @GetMapping("/investment")
    public ResponseDTO<List<InvestingStatusDTO>> investmentGet
            (
            @RequestHeader("X-USER-ID") Long userId
            )
    {
        return new ResponseDTO<>(investingService.getInvest(userId));
    }

    @PutMapping("/investment/{productId}")
    public ResponseDTO<InvestingStatusDTO> investmentPost(
            @RequestHeader("X-USER-ID") Long userId,
            @PathVariable Long productId,
            @RequestParam String status
    )
    {
        return new ResponseDTO<>
                (InvestingStatusMapper.INSTANCE.toDto
                        (investingService.updateInvest(userId, productId, status)));
    }

}
