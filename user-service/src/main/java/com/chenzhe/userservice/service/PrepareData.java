package com.chenzhe.userservice.service;

import com.chenzhe.userservice.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PrepareData implements InitializingBean {

    @Autowired
    private UserCommonService userCommonService;

    @Override
    public void afterPropertiesSet() throws Exception {
        //prepare
        User user = new User();
        user.setSureName("test");
        user.setFirstName("tc");
        user.setEmail("test@gmail.com");
        user.setCreateTime(System.currentTimeMillis());
        user.setGender("male");
        user.setSubscribedNewsletter("true");
        userCommonService.save(user);
        log.info("add init user {} into local db", user);

        User user1 = new User();
        user1.setSureName("test1");
        user1.setFirstName("tc");
        user1.setGender("female");
        user1.setEmail("test1@gmail.com");
        user1.setCreateTime(System.currentTimeMillis());
        user1.setSubscribedNewsletter("true");
        userCommonService.save(user1);
        log.info("add init user {} into local db", user1);

        User user2 = new User();
        user2.setSureName("test2");
        user2.setFirstName("tc");
        user2.setEmail("test2@gmail.com");
        user2.setGender("female");
        user2.setCreateTime(System.currentTimeMillis());
        user2.setSubscribedNewsletter("false");
        userCommonService.save(user2);
        log.info("add init user {} into local db", user2);
    }
}
