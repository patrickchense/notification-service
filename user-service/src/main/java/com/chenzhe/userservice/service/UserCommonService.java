package com.chenzhe.userservice.service;


import com.chenzhe.userservice.entity.User;
import com.chenzhe.userservice.pojo.QueryUser;

import java.util.List;

public interface UserCommonService {

    List<User> findAllUsers(QueryUser queryUser);

    User updateUser(User old, User user);

    void deleteUser(Long id);

    User save(User user);

    void deleteAll();
}
