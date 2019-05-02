package com.tgrajkowski.authortization;

import com.tgrajkowski.authortization.model.user.Role;
import com.tgrajkowski.authortization.model.user.User;
import com.tgrajkowski.authortization.model.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthorizationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorizationServerApplication.class, args);
    }

    @Autowired
    private UserDao userDao;

    @Bean
    public void initData() {
        if (userDao.count()==0) {
            Role roleU = new Role();
            roleU.setName("user");
            roleU.setCode("user");
            Role roleA = new Role();
            roleA.setName("admin");
            roleA.setCode("admin");


            User user = new User();
            user.setLogin("tomek");
            user.setPassword("$2a$10$wb2bCJss3flkLUCpq6D5GemoANM9jwaIrt7mNTAjo5UFt2P77ruwK");
            user.getRoleList().add(roleA);
            user.getRoleList().add(roleU);
            roleA.getUserList().add(user);
            roleU.getUserList().add(user);
            userDao.save(user);
        }



    }
}
