package com.tgrajkowski.service;

import com.tgrajkowski.model.role.Role;
import com.tgrajkowski.model.role.RoleDao;
import com.tgrajkowski.model.user.User;
import com.tgrajkowski.model.user.UserDao;
import com.tgrajkowski.model.user.UserDto;
import com.tgrajkowski.model.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleDao roleDao;

    public UserDto getUserByLogin(String login) {
        User user = userDao.findByLogin(login);
        return userMapper.mapToUserDto(user);
    }

    public UserDto signUp(UserDto userDto) {
        User user = userMapper.mapToUser(userDto);
        Role role = roleDao.findByName("user");
        user.getRoleList().add(role);
        userDao.save(user);
        userDto.setId(user.getId());
        return userDto;
    }
}
