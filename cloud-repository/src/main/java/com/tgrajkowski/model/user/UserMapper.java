package com.tgrajkowski.model.user;

import com.tgrajkowski.model.role.Role;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper {
    public UserDto mapToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRoleList(
                user.getRoleList().stream().map(Role::getCode).collect(Collectors.toList())
        );
        return userDto;
    }

    public User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(user.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
