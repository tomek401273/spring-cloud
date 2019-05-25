package com.tgrajkowski.controller;

import com.tgrajkowski.model.user.User;
import com.tgrajkowski.model.user.UserDto;
import com.tgrajkowski.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "user/")
public class UserController {

    @Autowired
    public UserService userService;

    @RequestMapping(value = "by/login")
    public UserDto getUserByLogin(@RequestParam String login) {
        return userService.getUserByLogin(login);
    }

    @RequestMapping(value = "sign/up", method = RequestMethod.POST)
    public UserDto signUpUser(@RequestBody UserDto userDto){
        return userService.signUp(userDto);
    }
}
