package com.chenzhe.userservice.service;


import com.chenzhe.userservice.UserServiceApplicationTests;
import com.chenzhe.userservice.dao.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.chenzhe.userservice.entity.User;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = UserServiceApplicationTests.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestUserService {

    // https://medium.freecodecamp.org/unit-testing-services-endpoints-and-repositories-in-spring-boot-4b7d9dc2b772
    /*
    这里因为是interface实现不能用interface，而只能注入Impl才能injectMocks
    还有一种方式不用InjectMocks,  https://tedvinke.wordpress.com/2014/02/13/mockito-why-you-should-not-use-injectmocks-annotation-to-autowire-fields/
    采用Mock, 在Before中初始化Impl, 然后把Mock注入进去(constructor)
     */
    @InjectMocks
    private UserCommonServiceImpl userCommonService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void init() {
        //userCommonService = new UserCommonServiceImpl();
    }


    @Test
    public void testFindById() {
        User u = new User();
        u.setFirstName("test3");
        u.setEmail("test3@gmail.com");
        u.setId(1L);
        when(userRepository.findById(any(Long.class))).thenReturn(Optional.of(u));
        User user1 = userCommonService.findById(u.getId());
        Assert.assertNotNull(user1);
        Assert.assertEquals(u.getEmail(), user1.getEmail());
        Assert.assertEquals(u.getFirstName(), user1.getFirstName());
    }

    @Test
    public void testFindAll() {

    }
}
