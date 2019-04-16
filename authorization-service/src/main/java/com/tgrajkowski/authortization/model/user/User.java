package com.tgrajkowski.authortization.model.user;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema ="spring_cloud", name = "users")
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
}
