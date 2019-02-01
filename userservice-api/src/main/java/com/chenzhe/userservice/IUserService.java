package com.chenzhe.userservice;

import java.util.List;

public interface IUserService {

    UserRpc findById(Long id);

    List<UserRpc> findAllUsers();
}