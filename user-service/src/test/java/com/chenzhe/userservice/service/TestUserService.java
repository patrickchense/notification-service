package com.chenzhe.userservice.service;


import com.chenzhe.userservice.IUserService;
import com.chenzhe.userservice.UserServiceApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.chenzhe.userservice.entity.User;

import java.util.List;

@SpringBootTest(classes = UserServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserService {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserCommonService userCommonService;

    @Test
    public void testFindById() {
        User u = new User();
        u.setName("test3");
        u.setEmail("test3@gmail.com");
        u = userCommonService.save(u);
        Assert.assertNotNull(u.getId());
        User user1 = userService.findById(u.getId());
        Assert.assertNotNull(user1);
        Assert.assertEquals(u.getEmail(), user1.getEmail());
        Assert.assertEquals(u.getEmail(), user1.getEmail());
        Assert.assertEquals(u.getName(), user1.getName());
    }

    @Test
    public void testFindAll() {
        List<User> users = userService.findAllUsers();
        Assert.assertNotNull(users);
        Assert.assertEquals(2, users.size());
        users.sort((a, b) -> (int)(a.getCreateTime() - b.getCreateTime()));
        Assert.assertEquals(users.get(0).getName(), "test");
        Assert.assertEquals(users.get(1).getEmail(), "test1@gmail.com");
    }
}
