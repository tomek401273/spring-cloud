package com.tgrajkowski.authortization.model.user;

import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String login;
    private String password;
    private List<String> roleList = new ArrayList<>();
}
