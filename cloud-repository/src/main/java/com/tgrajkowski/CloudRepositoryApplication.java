package com.tgrajkowski;

import com.tgrajkowski.model.role.Role;
import com.tgrajkowski.model.user.User;
import com.tgrajkowski.model.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import brave.sampler.Sampler;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudRepositoryApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudRepositoryApplication.class, args);
    }

    @Value("${cloud-repository.own.value}")
    private String myString;

    @Autowired
    private UserDao userDao;

    @Bean
    public void initData() {
        System.out.println("checkoing is it really working...: "+myString);
        if (userDao.count() == 0) {
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
    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
