package com.chenzhe.userservice.exp;


public class UserNotExistException extends RuntimeException {

    public UserNotExistException(String msg) {
        super(msg);
    }
}
