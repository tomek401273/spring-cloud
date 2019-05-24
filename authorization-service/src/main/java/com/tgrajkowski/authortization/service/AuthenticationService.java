package com.tgrajkowski.authortization.service;

import com.tgrajkowski.authortization.model.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserDaoProxy userDaoProxy;
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


    //    public UserDto signUp(UserDto userDto) {
//        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
//        userDto = userDaoProxy.saveUser(userDto);
//        return userDto;
//    }
    public UserDto signUp(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return userDaoProxy.saveUser(userDto);
    }
}
