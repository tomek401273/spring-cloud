package com.tgrajkowski.model.user;

import com.tgrajkowski.model.role.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String login;

    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(
            name = "User_Roles",
            joinColumns = {@JoinColumn (name = "users_id")},
            inverseJoinColumns = {@JoinColumn (name = "roles_id")}
    )
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
