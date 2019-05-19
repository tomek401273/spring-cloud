package com.tgrajkowski.authortization.service;

import com.tgrajkowski.authortization.model.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserDao userDao;

    public UserDto signUp(UserDto userDto) {
        User user = userMapper.mapToUserPasswordEncode(userDto);
        Role role = roleDao.findByName("user");
        user.getRoleList().add(role);
        userDao.save(user);
        userDto.setId(user.getId());
        return userDto;
    }
}
