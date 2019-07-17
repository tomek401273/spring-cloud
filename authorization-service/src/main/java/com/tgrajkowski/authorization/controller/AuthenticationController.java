package com.tgrajkowski.authorization.controller;

import com.tgrajkowski.authorization.model.user.UserDto;
import com.tgrajkowski.authorization.service.AuthenticationService;
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
