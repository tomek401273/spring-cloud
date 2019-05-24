package com.tgrajkowski.authortization.model.user;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;


@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    private String login;

    private String password;


    private List<Role> roleList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }
}
