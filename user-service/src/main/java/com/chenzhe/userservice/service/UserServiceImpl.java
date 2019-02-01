package com.chenzhe.userservice.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.chenzhe.userservice.IUserService;
import com.chenzhe.userservice.UserRpc;
import com.chenzhe.userservice.dao.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.chenzhe.userservice.entity.User;

import java.util.List;
import java.util.stream.Collectors;

@Service(interfaceClass = IUserService.class)
@Component
@Slf4j
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserRpc findById(Long id) {
        log.info("find user by id: {}", id);
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            UserRpc userRpc = new UserRpc();
            userRpc.setIdentifier(String.valueOf(user.getId()));
            userRpc.setName(user.getFirstName() + " " + user.getSureName());
            userRpc.setSalutation(user.getGender().equals("male") ? "Mr" : "Mrs");
            userRpc.setEmail(user.getEmail());
            return userRpc;

        }
        return null;
    }

    @Override
    public List<UserRpc> findAllUsers() {
        List<User> users = userRepository.findAllSubscribedNews();
        if (users != null && !users.isEmpty()) {
            return users.stream().map(u -> new UserRpc(String.valueOf(u.getId()), u.getFirstName() + " " + u.getSureName(), u.getGender().equals("male") ? "Mr" : "Mrs" , u.getEmail())).collect(Collectors.toList());
        }
        return null;
    }
}
