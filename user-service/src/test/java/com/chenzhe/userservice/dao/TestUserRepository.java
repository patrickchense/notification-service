package com.chenzhe.userservice.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import com.chenzhe.userservice.entity.User;

@RunWith(SpringRunner.class)
@ComponentScan("com.chenzhe.userservice")
@DataJpaTest
public class TestUserRepository {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testSave() {
        User user = new User();
        user.setName("test1");
        user.setEmail("test1@gmail.com");
        user.setCreateTime(System.currentTimeMillis());
        User user1 = userRepository.save(user);
        Assert.assertNotNull(user1.getId());
        User user2 = userRepository.findById(user1.getId()).get();
        Assert.assertEquals(user1.getEmail(), user2.getEmail());
        Assert.assertEquals(user1.getName(), user2.getName());
    }


    @Test
    public void testUpdate() {
        User user = new User();
        user.setName("test1");
        user.setEmail("test1@gmail.com");
        user.setCreateTime(System.currentTimeMillis());
        User user1 = userRepository.save(user);
        Assert.assertNotNull(user1.getId());
        user1.setEmail("test2@gmail.com");
        User user2 = userRepository.save(user1);
        Assert.assertEquals(user2.getEmail(), "test2@gmail.com");
    }

    @Test
    public void testDelete() {
        User user = new User();
        user.setName("test1");
        user.setEmail("test1@gmail.com");
        user.setCreateTime(System.currentTimeMillis());
        User user1 = userRepository.save(user);
        Assert.assertNotNull(user1.getId());
        userRepository.deleteById(user1.getId());
        Assert.assertFalse(userRepository.existsById(user1.getId()));
    }
}
