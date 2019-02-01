package com.chenzhe.templateservice.exp;


public class TemplateNotExistException extends RuntimeException {

    public TemplateNotExistException(String msg) {
        super(msg);
    }
}
