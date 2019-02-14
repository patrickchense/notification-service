package com.chenzhe.userservice.exp;


public class UserNotExistException extends RuntimeException {

    public UserNotExistException(Long id) {
        super("Could not find user:" + id);
    }
}
