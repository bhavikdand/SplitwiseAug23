package com.scaler.splitwiseaug23.controllers;

import com.scaler.splitwiseaug23.dtos.RegisterUserRequestDto;
import com.scaler.splitwiseaug23.dtos.RegisterUserResponseDto;
import com.scaler.splitwiseaug23.models.User;
import com.scaler.splitwiseaug23.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    public RegisterUserResponseDto registerUser(RegisterUserRequestDto dto){
        try{
            User user = userService.registerUser(dto.getPhoneNumber(), dto.getUserName(), dto.getPassword());
            return RegisterUserResponseDto.getSuccessResponse(user);
        } catch (Exception e){
            return RegisterUserResponseDto.getFailureResponse(e.getMessage());
        }
    }
}
