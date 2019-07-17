package com.tgrajkowski.authorization.service;

import com.tgrajkowski.authorization.model.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserDaoProxy userDaoProxy;
    @Autowired
    private UserDaoProxy userDaoProxy2;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserDto signUp(UserDto userDto) {
        userDto.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return userDaoProxy.saveUser(userDto);
    }
}
