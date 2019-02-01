package com.chenzhe.userservice.service;

import com.chenzhe.userservice.UserServiceApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = UserServiceApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserCommonService {

    @Autowired
    private UserCommonService userCommonService;

    @Test
    public void testUserSave() {

    }

    @Test
    public void testUserUpdate() {

    }

    @Test
    public void testFindAllByQuery() {

    }

    @Test
    public void testDelete() {

    }
}
