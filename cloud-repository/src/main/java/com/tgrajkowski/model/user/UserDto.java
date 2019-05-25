package com.tgrajkowski.model.user;

import com.tgrajkowski.model.role.Role;
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
