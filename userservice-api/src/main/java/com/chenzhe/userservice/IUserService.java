package com.chenzhe.userservice;

import com.chenzhe.userservice.entity.User;

import java.util.List;

public interface IUserService {

    User findById(Long id);

    List<User> findAllUsers();
}