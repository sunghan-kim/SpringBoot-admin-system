package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;


public class UserRepositoryTest extends StudyApplicationTests {

    @Autowired // DI(Dependency Injection), 객체를 직접 만들 지 않고 객체들을 Spring이 직접 관리하여 의존성을 주입하도록 지정 (singleton 객체)
    private UserRepository userRepository;

    @Test
    public void create() {
        User user = new User();
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(LocalDateTime.now());
        user.setCreatedBy("TestUser3");

        User newUser = userRepository.save(user);
        System.out.println("newUser : " + newUser);
    }

    public void read() {

    }

    public void update() {

    }

    public void delete() {

    }

}
