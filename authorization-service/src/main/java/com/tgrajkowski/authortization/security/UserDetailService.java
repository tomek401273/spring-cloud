package com.tgrajkowski.authortization.security;

import com.tgrajkowski.authortization.model.user.User;
import com.tgrajkowski.authortization.model.user.UserDao;
import com.tgrajkowski.authortization.model.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;
    private UserMapper userMapper = new UserMapper();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByLogin(username);
        return userMapper.mapToUserDetails(user);
    }
}
