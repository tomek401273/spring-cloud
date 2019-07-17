package com.tgrajkowski.authorization.security;

import com.tgrajkowski.authorization.model.user.UserDto;
import com.tgrajkowski.authorization.model.user.UserMapper;
import com.tgrajkowski.authorization.service.UserDaoProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    private UserMapper userMapper = new UserMapper();
    @Autowired
    private UserDaoProxy userDaoProxy;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = userDaoProxy.getUserByLogin(username);
        return userMapper.mapToUserDetails(userDto);
    }
}
