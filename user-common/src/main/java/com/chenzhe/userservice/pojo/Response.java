package com.chenzhe.userservice.pojo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Response {

    private String code;

    private String msg;

    public static final Response SUCCESS = new Response("0", "SUCCESS");
    public static final Response FAIL = new Response("1", "FAIL");
    public static final Response PARAM_INCORRECT = new Response("-1", "PARAM INCORRECT");
}
