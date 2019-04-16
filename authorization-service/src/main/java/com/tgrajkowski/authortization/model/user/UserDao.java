package com.tgrajkowski.authortization.model.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
    User findByLogin(String login);
}
