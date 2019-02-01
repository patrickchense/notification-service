package com.chenzhe.userservice.service;

import com.chenzhe.userservice.dao.UserRepository;
import com.chenzhe.userservice.exp.UserNotExistException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chenzhe.userservice.entity.User;
import com.chenzhe.userservice.pojo.QueryUser;

import java.util.List;

@Service
@Slf4j
public class UserCommonServiceImpl implements UserCommonService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers(QueryUser queryUser) {
        return null;
    }

    @Override
    public User updateUser(User old, User user) {
        if (!old.equals(user)) {
            log.info("update user from {} to {}", old, user);
            userRepository.save(user);
        }
        return user;
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        throw new UserNotExistException("user not exists");
    }

    @Override
    public User save(User user) {
        log.info("create user: {}", user);
        return userRepository.save(user);
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
