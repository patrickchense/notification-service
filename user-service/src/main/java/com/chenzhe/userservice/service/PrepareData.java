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
        user.setName("test");
        user.setEmail("test@gmail.com");
        user.setCreateTime(System.currentTimeMillis());
        user.setSalutation("Mr");
        user.setIdentifier("test001");
        userCommonService.save(user);
        log.info("add init user {} into local db", user);

        User user1 = new User();
        user1.setName("test1");
        user1.setEmail("test1@gmail.com");
        user1.setCreateTime(System.currentTimeMillis());
        user1.setSalutation("Mrs.");
        user1.setIdentifier("test002");
        userCommonService.save(user1);
        log.info("add init user {} into local db", user1);
    }
}
