package com.tgrajkowski.service;

import com.tgrajkowski.model.role.Role;
import com.tgrajkowski.model.role.RoleDao;
import com.tgrajkowski.model.user.User;
import com.tgrajkowski.model.user.UserDao;
import com.tgrajkowski.model.user.UserDto;
import com.tgrajkowski.model.user.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserDao userDao;

    @Mock
    private UserMapper userMapper;

    @Mock
    private RoleDao roleDao;

    @Test
    public void signUp() {
        // Given
        UserDto userDto = new UserDto();
        User user = new User();
        Mockito.when(userMapper.mapToUser(userDto)).thenReturn(user);
        Role role = new Role();
        Mockito.when(roleDao.findByName("user")).thenReturn(role);

        UserDto userDtoReturn = new UserDto();
        userDtoReturn.setLogin("login");
        userDtoReturn.setPassword("password");
        userDtoReturn.setId(1L);
        userDtoReturn.getRoleList().add("user");

        Mockito.when(userMapper.mapToUserDto(user)).thenReturn(userDtoReturn);
        // When
        UserDto result = userService.signUp(userDto);
        //Then
        Assert.assertEquals(Long.valueOf(1), result.getId());
        Assert.assertEquals("login", result.getLogin());
        Assert.assertEquals("password", result.getPassword());
        Assert.assertEquals("user", result.getRoleList().get(0));
    }
}
