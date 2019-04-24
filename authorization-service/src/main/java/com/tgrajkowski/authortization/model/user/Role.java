package com.tgrajkowski.authortization.model.user;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Setter
@Entity
@Table(name = "roles")
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column
    private String code;
    @Column
    private String name;
    @ManyToMany(mappedBy = "roleList", fetch = FetchType.EAGER)
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
