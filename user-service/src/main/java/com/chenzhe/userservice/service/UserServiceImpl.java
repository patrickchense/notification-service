package com.chenzhe.userservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chenzhe.userservice.IUserService;
import com.chenzhe.userservice.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.chenzhe.userservice.entity.User;

import java.util.List;

@Service(interfaceClass = IUserService.class)
@Component
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        log.info("find user by id: {}", id);
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
