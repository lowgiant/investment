package com.fastcampus.investment.api;

import com.fastcampus.investment.model.*;
import com.fastcampus.investment.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api")
public class Apis {
    // TODO: start
    private final UserService userService;

    @GetMapping("/product")
    public ResponseDto<List<ProductResponse>> findAllOpenProduct() {
        return new ResponseDto<>(userService.findAllProductValid(), HttpStatus.OK);
    }

    @PostMapping("/investment")
    public ResponseEntity<?> createInvestmentApiFail(@RequestHeader("X-USER-ID") Long userId, UserRequest userRequest){
        UserEntity result = this.userService.userAdd(userId, userRequest);
        if(result.getStatus().toString().equals("FAIL")){
            return ResponseEntity.ok(new ResponseDto(new ResponseData("FAIL"), HttpStatus.OK));
        }else{
            return ResponseEntity.ok().build();
        }

    }
    @GetMapping("/investment")
    public ResponseDto<List<UserResponse>> findInvestment(@RequestHeader("X-USER-ID") Long userId){
        return new ResponseDto<>(this.userService.findInvestByUserId(userId), HttpStatus.OK);
    }

    @PutMapping("/investment/{investId}")
    public void cancelInvestment(@RequestHeader("X-USER-ID") Long userId, @RequestParam("status") String status, @PathVariable long investId){
        if (status.equals(UserInvestmentStatus.CANCELED.toString())){
            userService.cancelInvestment(investId, userId);
        }
    }
}
