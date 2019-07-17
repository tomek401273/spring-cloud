package com.tgrajkowski.authorization.model.user;

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
public class Role {
    private long id;
    private String code;
    private String name;
    private List<User> userList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public List<User> getUserList() {
        return userList;
    }
}
