package com.tgrajkowski.authorization.service;

import com.tgrajkowski.authorization.model.user.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cloud-repository")
public interface UserDaoProxy {
    @GetMapping(value = "/user/by/login")
    UserDto getUserByLogin(@RequestParam("login") String login);

    @PostMapping(value = "user/sign/up")
    UserDto saveUser(@RequestBody UserDto userDto);
}
