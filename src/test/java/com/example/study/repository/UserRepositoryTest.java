package com.example.study.repository;


import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;


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

    @Test
    public void read() {
        Optional<User> user = userRepository.findById(1L);

        user.ifPresent(selectUser -> { // ifPresent : 있을 경우
            System.out.println("selectUser : " + selectUser);
            System.out.println("email : " + selectUser.getEmail());
        });
    }

    @Test
    @Transactional
    public void update() {
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser -> {
            selectUser.setAccount("PPPP");
            selectUser.setUpdatedAt(LocalDateTime.now());
            selectUser.setUpdatedBy("update method()");

            userRepository.save(selectUser);
        });
    }

    @Test
    @Transactional // 모든 메서드들은 실행되지만 실제 데이터에 대한 동작은 이뤄지지 않는다. (마지막에 다시 rollback을 해준다.)
    public void delete() {
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent()); // 반드시 값이 존재해야 한다. (true)

        user.ifPresent(selectUser -> {
            userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assert.assertFalse(deleteUser.isPresent()); // 값이 삭제되었으므로 존재하지 않아야 한다. (false)
    }

}
