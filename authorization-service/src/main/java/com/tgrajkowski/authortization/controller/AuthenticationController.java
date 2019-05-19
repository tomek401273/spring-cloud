package com.tgrajkowski.authortization.controller;

import com.tgrajkowski.authortization.model.user.UserDto;
import com.tgrajkowski.authortization.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public UserDto signUp(@RequestBody UserDto userDto) {
        return authenticationService.signUp(userDto);
    }
}
