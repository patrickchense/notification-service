package com.chenzhe.userservice.pojo;

import lombok.Data;

@Data
public class QueryUser {

    private Long id;

    private String name;

    private String email;

    private String emailLike;

    private String nameLike;

    private Long createTimeStart;

    private Long createTimeEnd;

    private int page;

    private int pageSize;
}
