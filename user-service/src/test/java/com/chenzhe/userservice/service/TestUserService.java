package com.chenzhe.userservice.service;


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

    // https://medium.freecodecamp.org/unit-testing-services-endpoints-and-repositories-in-spring-boot-4b7d9dc2b772
    // TODO test 写的有问题，需要改，用mock的方式参考上面的帖子
    @Autowired
    private UserCommonService userCommonService;

    @Test
    public void testFindById() {
        User u = new User();
        u.setFirstName("test3");
        u.setEmail("test3@gmail.com");
        u = userCommonService.save(u);
        Assert.assertNotNull(u.getId());
        User user1 = userCommonService.findById(u.getId());
        Assert.assertNotNull(user1);
        Assert.assertEquals(u.getEmail(), user1.getEmail());
        Assert.assertEquals(u.getEmail(), user1.getEmail());
        Assert.assertEquals(u.getFirstName(), user1.getFirstName());
    }

    @Test
    public void testFindAll() {
        List<User> users = userCommonService.findAll();
        Assert.assertNotNull(users);
        Assert.assertEquals(3, users.size());
        users.sort((a, b) -> (int)(a.getCreateTime() - b.getCreateTime()));
        Assert.assertEquals(users.get(0).getFirstName(), "tc");
        Assert.assertEquals(users.get(1).getEmail(), "test1@gmail.com");
    }
}
