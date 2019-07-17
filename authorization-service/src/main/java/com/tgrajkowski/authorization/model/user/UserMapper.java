package com.tgrajkowski.authorization.model.user;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {
    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public UserDto mapToUserDto(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(inputStream, UserDto.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public UserDetails mapToUserDetails(User user) {
        List<GrantedAuthority> userRoleList = user.getRoleList().stream()
                .map(role -> new SimpleGrantedAuthority(role.getCode()))
                .collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(), userRoleList);
    }

    public User mapToUserPasswordEncode(UserDto userDto) {
        User user = new User();
        String passwordEncoded =bCryptPasswordEncoder.encode(userDto.getPassword());
        user.setPassword(passwordEncoded);
        user.setLogin(userDto.getLogin());
        return user;
    }

    public UserDetails mapToUserDetails(UserDto userDto) {
        List<GrantedAuthority> grantedAuthorities =
                userDto.getRoleList().stream()
                        .map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(userDto.getLogin(), userDto.getPassword(), grantedAuthorities) ;
    }
}
