package com.BookMyShow.BMS.controllers;

import com.BookMyShow.BMS.Exception.UserNotFoundException;
import com.BookMyShow.BMS.dtos.ResponseStatus;
import com.BookMyShow.BMS.dtos.SignUpRequestDto;
import com.BookMyShow.BMS.dtos.SignUpResponseDto;
import com.BookMyShow.BMS.models.User;
import com.BookMyShow.BMS.services.UserService;

public class UserController {
    private UserService userService;

    public SignUpResponseDto userSignup(SignUpRequestDto signUpRequestDto) throws UserNotFoundException {
        SignUpResponseDto signUpResponseDto = new SignUpResponseDto();

        User user;
        try {
            user = userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword());
            signUpResponseDto.setUser_id(user.getId());
            signUpResponseDto.setResponseStatus(ResponseStatus.SUCCESS);

        }
        catch (Exception ex){
            signUpResponseDto.setResponseStatus(ResponseStatus.FAILED);
        }
        return signUpResponseDto;
    }
}
